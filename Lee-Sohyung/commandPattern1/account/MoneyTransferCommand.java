package commandPattern1.account;

import commandPattern1.command.DependentCompositeCommand;

/**
 * 두 은행 계좌 간에 돈을 이체하는 명령 클래스 (ConcreteCommand)
 *
 * @author Lee Sohyeong
 */
public class MoneyTransferCommand extends DependentCompositeCommand {

    /**
     * MoneyTransferCommand 인스턴스를 생성한다.
     *
     * @param from 송금(출금) 계좌
     * @param to 입금계좌
     * @param amount 이체 금액
     */
    public MoneyTransferCommand(BankAccount from, BankAccount to, int amount) {
        addCommand(new BankAccountCommand(from, ActionType.WITHDRAW, amount));
        addCommand(new BankAccountCommand(to, ActionType.DEPOSIT, amount));
    }

}
