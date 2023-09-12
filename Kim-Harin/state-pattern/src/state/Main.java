package state;
/**
 *  @version : 1.0.1
 *  @author : harin
 * <h3>Main 클래스는 BankAccount 및 해당 상태를 보여주는 기능을 구현합니다.</h3>
 * <p>
 * 이 클래스는 다양한 상태에서 은행 계좌의 동작을 보여주기 위해 사용됩니다.
 * </p>
 * @see BankAccount
 * @see FrozenState
 * @version 1.0.1
 * @author harin
 */
public class Main {
    /**
     * main 메소드는 BankAccount 객체를 생성하고 계좌 잔액을 확인하며 계좌 상태를 변경합니다.
     *
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
