package commandPattern2;

import commandPattern2.account.*;
import commandPattern2.command.CompositeCommand;

/**
 * 동작 테스트용 클래스
 * 이 클래스는 Command 패턴을 테스트하고 은행 계좌에 대한 입금과 출금 명령을 실행한다.
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

        CompositeCommand commands = new CompositeCommand();

        // 2) BankAccountCommand 객체를 사용하여 입금 및 출금 명령을 생성한다. 명령들을 commands 에 저장한다.
        commands.addCommand(new BankAccountCommand(ba, ActionType.DEPOSIT, 100));
        commands.addCommand(new BankAccountCommand(ba, ActionType.WITHDRAW, 200));

        // 3) 초기 계좌 잔액을 출력한다.
        System.out.println("=== Initial balance: ");
        System.out.println(ba);

        // 4) 명령들을 차례대로 실행한다.
        commands.call();

        System.out.println("=== Final balance: ");
        System.out.println(ba);

        // 5) 명령들을 역순으로 되돌린다.
        commands.undo();

        // 6) 명령을 실행한 결과 계좌 잔액을 다시 출력한다.
        System.out.println("=== Balance after undo: ");
        System.out.println(ba);

    }
}
