/**
 * 은행 계좌에 대한 기본 동작들을 정의하는 인터페이스
 * 계좌에 입금, 잔액 조회, 출금을 구할 수 있다.
 */
public interface BankAccount {

    /**
     * 주어진 금액을 계좌에 입금
     * 
     * @param amount 입금할 금액. 양수여야 한다.
     */
    void deposit(double amount);

    /**
     * 현재 계좌의 잔액을 조회
     * 
     * @return 현재 계좌의 잔액.
     */
    double getBalance();

    /**
     * 주어진 금액을 계좌에서 출금
     * 잔액이 부족한 경우 출금이 이루어지지 않을 수 있다.
     * 
     * @param amount 출금할 금액. 양수여야 한다.
     */
    void withdraw(double amount);
}

