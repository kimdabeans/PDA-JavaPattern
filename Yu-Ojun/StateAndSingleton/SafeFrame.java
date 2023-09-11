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

import static StateAndSingleton.Main.balance;

public class SafeFrame extends Frame implements ActionListener, Context{
	private TextArea textInfo = new TextArea(3,60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonBuy = new Button("Buy");
	private Button buttonSell = new Button("Sell");
	private Button buttonExit = new Button("Exit");

	private int stock;
	private State state;
	private TimeType timeType;
	private Time time;
	
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
	
	@Override
	public void setInfo(int hour, TimeType timeType, StateType stateType, int stock) {
		state = stateType.getState();
		time = timeType.getTime();
		this.stock = stock;

		String clockString = String.format("주식 장 시간 : 8:00 ~ 16:00\n현재 시간 : %02d:00\n현재 주가 : %d\n고객님의 잔액은 %d원입니다", hour, stock, balance);
		System.out.println(clockString);
		textInfo.setText(clockString);
	}

	@Override
	public int getStock(){
		return stock;
	}

	@Override
	public void callTransactionAlarm(String msg) {
		textScreen.append("주식 거래 알림입니다. "+msg +"\n");
	}

	@Override
	public void setTimeType(TimeType timeType) {
		this.timeType = timeType;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		time.doAlarm(this);
		if(e.getSource() == buttonBuy) {
			if(timeType != TimeType.CLOSE_TIME) {
				balance = state.buy(this);
				String clockString = String.format("구매 완료!\n현재 주가 : %d\n고객님의 잔액은 %d원입니다\n", stock, balance);
				textScreen.append(clockString);
			}
		}
		else if(e.getSource() == buttonSell) {
			if(timeType != TimeType.CLOSE_TIME) {
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
