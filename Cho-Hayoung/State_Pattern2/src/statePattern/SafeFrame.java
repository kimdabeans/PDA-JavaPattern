package statePattern;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.*;

/**
 * SafeFrame 클래스는 상태 패턴(State Pattern)에서 Context 역할을 하는 프레임(Frame) 클래스입니다.
 * 이 프레임은 금고의 현재 상태를 표시하고 사용자의 입력을 처리합니다.
 *
 * 이 클래스는 다음과 같은 상태 관리와 사용자 상호작용을 수행합니다:
 * - 현재 시간을 표시하고 시간에 따른 상태 변경을 처리합니다.
 * - 긴급 호출과 기록 작성을 처리합니다.
 * - 사용자 입력에 따라 상태별로 다른 동작을 수행합니다.
 *
 * @author Cho hayoung
 */
public class SafeFrame extends Frame implements ActionListener, Context {

    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10, 60);
    private Button buttonUse = new Button("금고 사용");
    private Button buttonAlarm = new Button("비상벨");
    private Button buttonPhone = new Button("일반 통화");
    private Button buttonExit = new Button("종료");
    private State state = DayState.getInstance();
    private static HashMap<Integer, Hours> timeMap = new HashMap<Integer, Hours>();

    /**
     * SafeFrame 클래스의 생성자입니다.
     *
     * @param title 프레임의 제목
     */
    public SafeFrame(String title) {
        super(title);
        timeMap = makeMap(24);
        setBackground(Color.white);
        setLayout(new BorderLayout());

        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);

        add(panel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    /**
     * 현재 시간을 화면에 표시하고, 상태를 변경합니다.
     *
     * @param hour 현재 시간
     */
    public void setClock(int hour) {
        String clockString = String.format("현재 시간 %02d:00", hour);
        textClock.setText(clockString);
        State newState = this.timeMap.get(hour).getState();
        state.doClock(this, newState);
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state + " 상태가 " + state + " 상태로 변경되었습니다.");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("긴급 호출: " + msg + "\n");
    }

    @Override
    public void recordLog(String msg) {
        textScreen.append("기록 중..." + msg + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonUse) {
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {
            state.recordPhone(this);
        } else if (e.getSource() == buttonExit) {
            System.exit(0);
        }
    }

    /**
     * 시간대에 따른 상태 정보를 담은 HashMap을 생성합니다.
     *
     * @param i 시간대의 최대 값 (보통 24)
     * @return 시간대와 상태 정보를 매핑한 HashMap
     */
    public HashMap<Integer, Hours> makeMap(int i) {
        HashMap<Integer, Hours> mapinit = new HashMap<>();
        for (int j = 0; j < i; j++) {
            if (j >= 11 && j <= 12) {
                mapinit.put(j, Hours.LUNCH_STATE);
                continue;
            } else if (j >= 8 && j <= 17) {
                mapinit.put(j, Hours.DAY_STATE);
            } else mapinit.put(j, Hours.NIGHT_STATE);
        }
        return mapinit;
    }
}
