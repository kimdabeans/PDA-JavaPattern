package state;
/**
 * <h3>FrozenState 클래스는 은행 계좌의 "동결된 상태"를 나타냅니다.</h3>
 *
 * <p>
 * 이 상태에서는 계좌에 입금과 출금 작업이 불가능하며 계좌 확인 및 동결 상태 변경만 가능합니다.
 * </p>
 * @see AccountStatus
 * @see Context
 * @version 1.0.1
 * @author harin
 */
class FrozenState implements AccountStatus {

    private static FrozenState singleton = new FrozenState();

    /**
     * FrozenState 클래스는 private 생성자를 가지며, 외부에서 인스턴스화할 수 없습니다.
     */
    private FrozenState() {
    }

    /**
     * FrozenState의 singleton를 반환합니다.
     *
     * @return FrozenState의 singleton
     */
    public static AccountStatus getInstance() {
        return singleton;
    }

    /**
     * 계좌에 입금을 시도하면 "Account is frozen. Cannot deposit." 메시지를 출력합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     * @param amount  입금할 금액
     */
    @Override
    public void deposit(Context context, int amount) {
        System.out.println("Account is frozen. Cannot deposit.");
    }

    /**
     * 계좌에서 출금을 시도하면 "Account is frozen. Cannot withdraw." 메시지를 출력합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     * @param amount  출금할 금액
     */
    @Override
    public void withdraw(Context context, int amount) {
        System.out.println("Account is frozen. Cannot withdraw.");
    }

    /**
     * 계좌 확인을 시도하면 "Account is frozen." 메시지를 출력합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     */
    @Override
    public void verifyAccount(Context context) {
        System.out.println("Account is frozen.");
    }

    /**
     * 계좌 동결 상태 변경을 시도하면 "Account is already frozen." 메시지를 출력합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     */
    @Override
    public void freezeAccount(Context context) {
        System.out.println("Account is already frozen.");
    }
}