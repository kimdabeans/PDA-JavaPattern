package commandPattern2.account;

/**
 * BankAccountCommand 에서 사용할 액션 인터페이스
 *
 * @author Lee Sohyeong
 */
public interface BankAccountAction {
    /**
     * 명령을 실행하는 메소드
     *
     * @param account 명령을 수행할 은행 계좌
     * @param amount 금액
     * @return 성공 여부
     */
    boolean execute(BankAccount account, int amount);

    /**
     * 명령을 되돌리는 메소드
     *
     * @param account 명령을 수행할 은행 계좌
     * @param amount 금액
     */
    void undo(BankAccount account, int amount);
}
