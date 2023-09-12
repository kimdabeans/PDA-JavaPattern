/**
 * 실제 은행 계좌를 표현하는 클래스
 * 계좌의 기본 동작들을 구현
 */
public class RealBankAccount implements BankAccount {
    
    private double balance;

    /**
     * 지정된 금액을 계좌에 입금합니다.
     *
     * @param amount 입금할 금액. (양수 값)
     */
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * 현재 계좌의 잔액을 반환
     *
     * @return 계좌의 현재 잔액.
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /**
     * 지정된 금액만큼 계좌에서 출금
     * 잔액이 출금하려는 금액보다 적을 경우 출금되지 않는다.
     *
     * @param amount 출금하려는 금액. (양수 값)
     */
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("잔액이 부족합니다!");
        }
    }
}

