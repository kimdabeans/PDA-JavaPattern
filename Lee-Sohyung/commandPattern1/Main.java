package commandPattern1;

import commandPattern1.account.*;
import commandPattern1.command.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 동작 테스트용 클래스
 * 은행 계좌 관련 명령 실행을 보여준다.
 *
 * @author Lee Sohyeong
 */
public class Main {

    /**
     * Command 패턴 테스트를 실행한다.
     *
     * @param args
     */
    public static void main(String[] args) {

        // 1) BankAccount 객체를 생성한다.
        BankAccount ba = new BankAccount();

        List<Command> commands = new ArrayList<>();
        // 2) BankAccountCommand 객체를 사용하여 입금 및 출금 명령을 생성한다. 명령들을 commands 에 저장한다.
        commands.add(new BankAccountCommand(ba, ActionType.DEPOSIT, 100));
        commands.add(new BankAccountCommand(ba, ActionType.WITHDRAW, 200));

        // 3) 초기 계좌 잔액을 출력한다.
        System.out.println("=== Initial balance: ");
        System.out.println(ba);

        // 4) 명령들을 차례대로 실행한다.
        for (Command cmd : commands) {
            cmd.call();
        }

        System.out.println("=== Final balance: ");
        System.out.println(ba);

        // 5) 명령들을 역순으로 되돌린다.
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }

        // 6) 명령을 실행한 결과 계좌 잔액을 다시 출력한다.
        System.out.println("=== Balance after undo: ");
        System.out.println(ba);


        // 두 은행 계좌 간에 돈을 이체하는 테스트를 실행한다. //
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        System.out.println("\nInitial balances:");
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);

        int transferAmount = 50;
        MoneyTransferCommand transferCommand = new MoneyTransferCommand(account1, account2, transferAmount);
        transferCommand.call();

        System.out.println("\nAfter money transfer:");
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);

        transferAmount = 500;
        transferCommand = new MoneyTransferCommand(account1, account2, transferAmount);
        transferCommand.call();

        System.out.println("\nAfter money transfer:");
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);

    }
}
