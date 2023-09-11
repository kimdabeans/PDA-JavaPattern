package state;
/**
 * OpenState 클래스는 은행 계좌의 "열린 상태"를 나타냅니다.
 * 이 상태에서는 계좌에 입금, 출금, 계좌 확인, 계좌 동결 기능을 수행할 수 있습니다.
 * <p>
 * 이 클래스는 Singleton 패턴을 따라 구현되었으며, getInstance() 메소드를 통해 단일 인스턴스를 반환합니다.
 * </p>
 * <p>
 * Usage:
 * <pre>
 *     // OpenState 인스턴스 가져오기
 *     AccountStatus state = OpenState.getInstance();
 *
 *     // 계좌에 입금하기
 *     state.deposit(context, amount);
 *
 *     // 계좌에서 출금하기
 *     state.withdraw(context, amount);
 *
 *     // 계좌 확인
 *     state.verifyAccount(context);
 *
 *     // 계좌 동결
 *     state.freezeAccount(context);
 * </pre>
 * </p>
 * <p>
 * 참고: 이 클래스는 은행 계좌 상태를 나타내며, 입금 및 출금 작업과 관련된 기능을 제공합니다.
 * </p>
 * @see AccountStatus
 * @see Context
 * @see FrozenState
 */
class OpenState implements AccountStatus {

    private static OpenState singleton = new OpenState();

    /**
     * OpenState 클래스는 Singleton 패턴을 따르므로 private 생성자를 가지며, 외부에서 인스턴스화할 수 없습니다.
     */
    private OpenState() {
    }

    /**
     * OpenState의 단일 인스턴스를 반환합니다.
     *
     * @return OpenState의 단일 인스턴스
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
