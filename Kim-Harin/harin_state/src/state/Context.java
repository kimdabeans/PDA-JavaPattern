package state;
/**
 * Context 인터페이스는 은행 계좌의 상태를 관리하기 위한 메소드를 정의합니다.
 * 계좌의 잔액을 설정하고 가져오며, 계좌 상태 변경 및 계좌 확인 기능을 제공합니다.
 * <p>
 * 이 인터페이스를 구현한 클래스는 은행 계좌의 상태와 관련된 동작을 제공해야 합니다.
 * </p>
 * <p>
 * 사용 예시:
 * <pre>
 *     // 계좌의 잔액 설정
 *     void setBalance(int balance);
 *
 *     // 계좌의 잔액 가져오기
 *     int getBalance();
 *
 *     // 계좌 잔액 확인
 *     void checkBalance();
 *
 *     // 계좌 상태 변경
 *     void changeState(AccountStatus state);
 * </pre>
 * </p>
 * <p>
 * 참고: 이 인터페이스는 은행 계좌의 상태 관리를 위한 일반적인 메소드를 정의하며,
 * 실제 동작은 구현 클래스에서 제공되어야 합니다.
 * </p>
 * @see AccountStatus
 */
interface Context {
    /**
     * 계좌의 잔액을 설정합니다.
     *
     * @param balance 계좌의 잔액
     */
    void setBalance(int balance);

    /**
     * 계좌의 현재 잔액을 반환합니다.
     *
     * @return 계좌의 현재 잔액
     */
    int getBalance();

    /**
     * 계좌의 잔액을 확인하고 출력합니다.
     */
    void checkBalance();

    /**
     * 계좌의 상태를 변경합니다.
     *
     * @param state 변경할 계좌 상태
     */
    void changeState(AccountStatus state);
}
