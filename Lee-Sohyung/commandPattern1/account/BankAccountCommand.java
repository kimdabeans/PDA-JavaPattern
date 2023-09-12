package commandPattern1.account;

import commandPattern1.command.Command;

/**
 * 은행 계좌에 대한 명령을 표현하는 클래스 (ConcreteCommand; Leaf)
 * @author Lee Sohyeong
 */
public class BankAccountCommand implements Command {

    // 명령을 수행할 은행 계좌
    private BankAccount account;
    private ActionType action;
    // 입금 또는 출금할 금액
    private int amount;
    // 명령의 성공 여부를 나타내는 변수
    private boolean succeeded = false;

    /**
     * BankAccountCommand 인스턴스를 생성한다.
     *
     * @param account 계좌 객체
     * @param action 액션 (deposit 또는 withdraw)
     * @param amount 금액
     */
    public BankAccountCommand(BankAccount account, ActionType action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    /**
     * 명령을 수행하며, 종류에 따라 은행 계좌의 입금 또는 출금을 처리한다.
     */
    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                account.deposit(amount);
                succeeded = true;
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    /**
     * 명령을 취소하며, 종류에 따라 은행 계좌의 입금 또는 출금을 취소한다.
     */
    @Override
    public void undo() {
        if (!succeeded) return;
        switch (action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }

    @Override
    public boolean isSucceeded() {
        return succeeded;
    }

}
