package StatePattern.Example01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 안전 관리 시스템의 GUI를 나타내는 클래스입니다.
 * 이 클래스는 프레임(Frame)을 상속하며, ActionListener 및 Context 인터페이스를 구현합니다.
 */
public class SafeFrame extends Frame implements ActionListener, Context {
  private TextField textClock = new TextField(60);
  private TextArea textScreen = new TextArea(10, 60);
  private Button buttonUse = new Button("금고 사용");
  private Button buttonAlarm = new Button("비상벨");
  private Button buttonPhone = new Button("일반 통화");
  private Button buttonExit = new Button("종료");

  private State state = DayState.getInstance();

  /**
   * SafeFrame 클래스의 생성자입니다.
   *
   * @param title 프레임의 제목
   */
  public SafeFrame(String title) {
    super(title);
    setBackground(Color.lightGray);
    setLayout(new BorderLayout());

    // textClock 배치
    add(textClock, BorderLayout.NORTH);
    textClock.setEditable(false);

    // textScreen 배치
    add(textScreen, BorderLayout.CENTER);
    textScreen.setEditable(false);

    // 패널에 버튼 저장
    Panel panel = new Panel();
    panel.add(buttonUse);
    panel.add(buttonAlarm);
    panel.add(buttonPhone);
    panel.add(buttonExit);

    // 그 패널을 배치
    add(panel, BorderLayout.SOUTH);

    // 표시
    pack();
    setVisible(true);

    // 리스너 설정
    buttonUse.addActionListener(this);
    buttonAlarm.addActionListener(this);
    buttonPhone.addActionListener(this);
    buttonExit.addActionListener(this);
  }

  /**
   * 버튼이 클릭되었을 때 호출되는 메서드입니다.
   *
   * @param e ActionEvent 객체
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.toString());
    if (e.getSource() == buttonUse) {		// 금고 사용 버튼
      state.doUse(this);
    } else if (e.getSource() == buttonAlarm) {	// 비상벨 버튼
      state.doAlarm(this);
    } else if (e.getSource() == buttonPhone) {	// 일반 통화 버튼
      state.doPhone(this);
    } else if (e.getSource() == buttonExit) {	// 종료 버튼
      System.exit(0);
    } else {
      System.out.println("?");
    }
  }

  /**
   * 시계를 설정하고 상태를 변경하는 메서드입니다.
   *
   * @param hour 시간
   */
  @Override
  public void setClock(int hour) {
    String clockstring = String.format("현재 시간은 %02d:00", hour);
    System.out.println(clockstring);
    textClock.setText(clockstring);
    state.doClock(this, hour);
  }

  /**
   * 상태를 변경하는 메서드입니다.
   *
   * @param state 변경할 상태 객체
   */
  @Override
  public void changeState(State state) {
    System.out.println(this.state + "에서 " + state + "으로 상태가 변화했습니다.");
    this.state = state;
  }

  /**
   * 경비 센터에 경보 메시지를 호출하는 메서드입니다.
   *
   * @param msg 호출할 메시지
   */
  @Override
  public void callSecurityCenter(String msg) {
    textScreen.append("call! " + msg + "\n");
  }

  /**
   * 경비 센터에 로그 메시지를 기록하는 메서드입니다.
   *
   * @param msg 기록할 메시지
   */
  @Override
  public void recordLog(String msg) {
    textScreen.append("record ... " + msg + "\n");
  }
}


