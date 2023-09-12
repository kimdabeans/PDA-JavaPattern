package state;
/**
 * <h3>OpenState 클래스는 은행 계좌의 "열린 상태"를 나타냅니다.</h3>
 *
 * <p>
 * 이 상태에서는 계좌에 입금, 출금, 계좌 확인, 계좌 동결 기능을 수행할 수 있습니다.
 * </p>
 *
 * @see AccountStatus
 * @see Context
 * @see FrozenState
 */
class OpenState implements AccountStatus {

    private static OpenState singleton = new OpenState();

    /**
     * OpenState 클래스는 private 생성자를 가지며, 외부에서 인스턴스화할 수 없습니다.
     */
    private OpenState() {
    }

    /**
     * @return OpenState의 singleton
     */
    public static AccountStatus getInstance() {
        return singleton;
    }

    /**
     * 계좌에 입금합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     * @param amount  입금할 금액
     */
    @Override
    public void deposit(Context context, int amount) {
        int currentBalance = context.getBalance();
        context.setBalance(currentBalance + amount);
    }

    /**
     * 계좌에서 출금합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     * @param amount  출금할 금액
     */
    @Override
    public void withdraw(Context context, int amount) {
        int currentBalance = context.getBalance();
        if (currentBalance >= amount) {
            context.setBalance(currentBalance - amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    /**
     * 계좌를 확인합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     */
    @Override
    public void verifyAccount(Context context) {
        System.out.println("Account is open.");
    }

    /**
     * 계좌를 동결합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     */
    @Override
    public void freezeAccount(Context context) {
        context.changeState(FrozenState.getInstance());
    }
}
