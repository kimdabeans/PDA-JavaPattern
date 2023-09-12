package state;
/**
 * <h3>AccountStatus 인터페이스는 은행 계좌의 동작을 정의하는 메소드를 선언합니다.</h3>
 *
 * <p>
 * 입금, 출금, 계좌 확인, 계좌 동결과 같은 은행 계좌 관련 동작에 대한 메소드를 포함하며,
 * 이 인터페이스를 구현한 클래스는 각 계좌 상태에 따른 동작을 제공할 수 있습니다.
 * </p>
 *
 * @see Context
 * @see OpenState
 * @see FrozenState
 * @version 1.0.1
 * @author harin
 */
interface AccountStatus {
    /**
     * 계좌에 입금을 수행하는 메소드를 정의합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     * @param amount  입금할 금액
     */
    void deposit(Context context, int amount);

    /**
     * 계좌에서 출금을 수행하는 메소드를 정의합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     * @param amount  출금할 금액
     */
    void withdraw(Context context, int amount);

    /**
     * 계좌를 확인하는 메소드를 정의합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     */
    void verifyAccount(Context context);

    /**
     * 계좌를 동결하는 메소드를 정의합니다.
     *
     * @param context 계좌 상태를 관리하는 컨텍스트
     */
    void freezeAccount(Context context);
}
