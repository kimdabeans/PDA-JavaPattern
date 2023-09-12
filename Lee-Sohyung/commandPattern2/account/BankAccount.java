package commandPattern2.account;

/**
 * 은행 계좌를 나타내는 클래스 (Receiver)
 * 계좌의 잔액을 관리하고 입금 및 출금 작업을 수행한다.
 *
 * @author Lee Sohyeong
 */
public class BankAccount {

    // 은행 계좌의 현재 잔액을 나타내는 변수
    private int balance = 0;
    // 계좌의 오버드래프트 한도를 나타내는 변수
    private int overdraftLimit = -500;

    /**
     * 입금 작업을 처리하는 메서드
     * 잔액을 증가시키고 입금 내역을 출력한다.
     *
     * @param amount 입금할 금액
     */
    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + "원 입금되었습니다. 현재 잔고: " + balance + "원");
    }

    /**
     * 출금 작업을 처리하는 메서드
     * 출금 가능한지 확인하고 출금 후 잔액을 감소시키며 출금 내역을 출력한다. true 를 반환한다.
     * 만약 출금 가능한 잔고 이상 출금을 시도하면 작업이 실패하고 false 를 반환한다.
     *
     * @param amount 출금할 금액
     * @return 출금이 성공하면 true, 실패하면 false
     */
    public boolean withdraw(int amount) {
        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println(amount + "원 출금되었습니다. 현재 잔고: " + balance + "원");
            return true;
        }
        System.out.println("충분한 잔액이 없습니다.");
        return false;
    }

    @Override
    public String toString() {
        return "현재 잔고: " + balance + "원";
    }
}
