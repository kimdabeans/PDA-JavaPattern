package state;
/**
 * AccountStatus 인터페이스는 은행 계좌의 상태를 정의하는 메소드를 선언합니다.
 * 입금, 출금, 계좌 확인, 계좌 동결과 같은 은행 계좌 관련 동작에 대한 메소드를 포함하며,
 * 이 인터페이스를 구현한 클래스는 은행 계좌의 다양한 상태를 나타내야 합니다.
 * <p>
 * 이 인터페이스를 구현하여 각 계좌 상태에 따른 동작을 제공할 수 있습니다.
 * </p>
 * <p>
 * 사용 예시:
 * <pre>
 *     // AccountStatus를 구현한 클래스에서 입금 동작 구현
 *     void deposit(Context context, int amount);
 *
 *     // AccountStatus를 구현한 클래스에서 출금 동작 구현
 *     void withdraw(Context context, int amount);
 *
 *     // AccountStatus를 구현한 클래스에서 계좌 확인 동작 구현
 *     void verifyAccount(Context context);
 *
 *     // AccountStatus를 구현한 클래스에서 계좌 동결 동작 구현
 *     void freezeAccount(Context context);
 * </pre>
 * </p>
 * <p>
 * 참고: 이 인터페이스는 은행 계좌 상태 관리를 위한 메소드를 정의하며,
 * 실제 동작은 구현 클래스에서 제공되어야 합니다.
 * </p>
 * @see Context
 * @see OpenState
 * @see FrozenState
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
