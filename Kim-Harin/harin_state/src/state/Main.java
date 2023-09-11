package state;
/**
 * Main 클래스는 BankAccount 및 해당 상태를 보여주는 기능을 구현합니다.
 * BankAccount 객체를 초기화하고 계좌 잔액을 확인하며 계좌 상태를 FrozenState로 변경합니다.
 * <p>
 * 이 클래스는 다양한 상태에서 은행 계좌의 동작을 보여주기 위한 진입점으로 사용됩니다.
 * </p>
 * <p>
 * 사용법:
 * <pre>
 *     public static void main(String[] args) {
 *         BankAccount account = new BankAccount();
 *
 *         // 계좌 잔액 확인
 *         account.checkBalance();
 *         account.checkBalance();
 *
 *         // 계좌 상태를 FrozenState로 변경
 *         account.changeState(FrozenState.getInstance());
 *     }
 * </pre>
 * </p>
 * <p>
 * 참고: 이 클래스는 데모용으로 사용되며 완전한 은행 시스템을 나타내지 않습니다.
 * </p>
 * @see BankAccount
 * @see FrozenState
 */
public class Main {
    /**
     * main 메소드는 BankAccount 객체를 생성하고 계좌 잔액을 확인하며 계좌 상태를 변경합니다.
     *
     * @param args 커맨드 라인 인수 (이 프로그램에서 사용되지 않음).
     */
    public static void main(String[] args) {
        /**
         * BankAccount 객체 생성.
         */
        BankAccount account = new BankAccount();

        /**
         * 계좌 잔액 확인.
         */
        account.checkBalance();
        account.checkBalance();

        /**
         * 계좌 상태를 FrozenState로 변경.
         */
        account.changeState(FrozenState.getInstance());
    }
}
