package state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * BankAccount 클래스는 은행 계좌를 나타내며 GUI를 통해 계좌의 상태를 관리합니다.
 * 입금, 출금, 계좌 확인, 계좌 동결, 계좌 상태 변경, 그리고 프로그램 종료 기능을 제공합니다.
 * <p>
 * 이 클래스는 AWT (Abstract Window Toolkit)를 사용하여 GUI를 구현하며, Context 인터페이스를 구현하여
 * 계좌 상태 및 관련 메소드를 제공합니다.
 * </p>
 * <p>
 * Usage:
 * <pre>
 *     // BankAccount 객체 생성 및 GUI 표시
 *     new BankAccount();
 * </pre>
 * </p>
 * <p>
 * 참고: 이 클래스는 은행 계좌를 시뮬레이션하며, 실제 은행 시스템과는 무관합니다.
 * </p>
 * @see Context
 * @see AccountStatus
 * @see OpenState
 * @see FrozenState
 */
public class BankAccount extends Frame implements ActionListener, Context {
    private int balance;
    private AccountStatus state = OpenState.getInstance(); // 현재 상태

    private TextField textBalance = new TextField(20);
    private Button buttonDeposit = new Button("Deposit");
    private Button buttonWithdraw = new Button("Withdraw");
    private Button buttonVerify = new Button("Verify Account");
    private Button buttonFreeze = new Button("Freeze Account");
    private Button buttonChangeState = new Button("Open Account");
    private Button buttonExit = new Button("Exit"); // Exit 버튼 추가
    private TextField textScreen = new TextField(20); // 텍스트 출력창 추가

    public BankAccount() {
        super("Bank Account Example");
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        Panel panel = new Panel();
        panel.add(textBalance);
        panel.add(buttonDeposit);
        panel.add(buttonWithdraw);
        panel.add(buttonVerify);
        panel.add(buttonFreeze);
        panel.add(buttonChangeState);
        panel.add(buttonExit); // Exit 버튼 추가
        add(panel, BorderLayout.NORTH);

        textBalance.setEditable(false);
        textBalance.setText("Balance: 0");

        buttonDeposit.addActionListener(this);
        buttonWithdraw.addActionListener(this);
        buttonVerify.addActionListener(this);
        buttonFreeze.addActionListener(this);
        buttonChangeState.addActionListener(this);
        buttonExit.addActionListener(this); // Exit 버튼에 ActionListener 추가

        add(textScreen, BorderLayout.CENTER); // 텍스트 출력창을 중앙에 추가

        pack();
        setVisible(true);

        balance = 0;
    }

    public static void main(String[] args) {
        new BankAccount();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonDeposit) {
            int amount = 100; // 예시로 100원 입금
            state.deposit(this, amount);
        } else if (e.getSource() == buttonWithdraw) {
            int amount = 50; // 예시로 50원 출금
            state.withdraw(this, amount);
        } else if (e.getSource() == buttonVerify) {
            state.verifyAccount(this);
        } else if (e.getSource() == buttonFreeze) {
            state.freezeAccount(this);
        } else if (e.getSource() == buttonChangeState) {
            changeState(OpenState.getInstance());
        } else if (e.getSource() == buttonExit) {
            // Exit 버튼을 클릭하면 프로그램 종료
            System.exit(0);
        }
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
        textBalance.setText("Balance: " + balance);
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void checkBalance() {
        // textScreen에 현재 잔액 표시
        textScreen.setText("Current balance: " + getBalance());
    }

    @Override
    public void changeState(AccountStatus newState) {
        state = newState;
        textScreen.setText("Account state changed to " + newState.getClass().getSimpleName());
    }
}
