package StateAndSingleton;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static StateAndSingleton.Utility.balance;

/**
 * SafeFrame 클래스입니다. ActionLister 인터페이스, Context 인터페이스를 구현했으며, Frame 클래스를 상속받았습니다.
 * JAVA GUI 를 구성하며 Context 인터페이스를 구현합니다.
 */
public class SafeFrame extends Frame implements ActionListener, Context{
	private TextArea textInfo = new TextArea(3,60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonBuy = new Button("Buy");
	private Button buttonSell = new Button("Sell");
	private Button buttonExit = new Button("Exit");

	private int stock;
	private State state;
	private Time time;
	/**
	 * GUI 창의 요소들의 정보와 배치를 지정하는 생성자입니다.
	 *
	 * @param title GUI 창의 이름을 정하는 String 객체
	 */
	public SafeFrame(String title) {
		super(title);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		add(textInfo, BorderLayout.NORTH);
		textInfo.setEditable(false);
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
		Panel panel = new Panel();
		panel.add(buttonBuy);
		panel.add(buttonSell);
		panel.add(buttonExit);

		add(panel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
		
		buttonBuy.addActionListener(this);
		buttonSell.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	/**
	 * Context 인터페이스의 메서드를 구현하여 현재 상태와 시간 정보를 화면에 표시합니다.
	 *
	 * @param hour      현재 시간 (시)
	 * @param timeType  현재 시간의 종류 (예: 주식 시장 열림, 주식 시장 닫힘)
	 * @param stateType 현재 고객 신용도 상태 (예: 경고, 위험, 정상)
	 * @param stock     현재 주식 가격
	 */
	@Override
	public void setInfo(int hour, TimeType timeType, StateType stateType, int stock) {
		state = stateType.getState();
		time = timeType.getTime();
		this.stock = stock;

		String clockString = String.format("주식 장 시간 : 8:00 ~ 16:00\n현재 시간 : %02d:00\n현재 주가 : %d\n고객님의 잔액은 %d원입니다", hour, stock, balance);
		System.out.println(clockString);
		textInfo.setText(clockString);
	}
	/**
	 * 현재 주식의 가격을 반환합니다.
	 *
	 * @return 현재 주식 가격
	 */
	@Override
	public int getStock(){
		return stock;
	}
	/**
	 * 주식 거래 알람 메시지를 화면에 표시합니다.
	 *
	 * @param msg 알람 메시지
	 */
	@Override
	public void callTransactionAlarm(String msg) {
		textScreen.append("주식 거래 알림입니다. "+msg +"\n");
	}

	/**
	 * 사용자의 동작 이벤트를 처리하는 메서드입니다.
	 *
	 * @param e ActionEvent 객체
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		time.doAlarm(this);
		if(e.getSource() == buttonBuy) {
			if(time.getTimeType() != TimeType.CLOSE_TIME) {
				balance = state.buy(this);
				String clockString = String.format("구매 완료!\n현재 주가 : %d\n고객님의 잔액은 %d원입니다\n", stock, balance);
				textScreen.append(clockString);
			}
		}
		else if(e.getSource() == buttonSell) {
			if(time.getTimeType() != TimeType.CLOSE_TIME) {
				balance = state.sell(this);
				String clockString = String.format("판매 완료!\n현재 주가 : %d\n고객님의 잔액은 %d원입니다\n", stock, balance);
				textScreen.append(clockString);
			}
		}
		else if(e.getSource() == buttonExit) {
			System.exit(0);
		}
	}


}
