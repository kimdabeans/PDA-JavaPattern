package factoryMethod;
/**
 * 계좌의 생성, 입출금, 잔액조회를 정의하는 인터페이스.
 */
public interface Account {
	/** 계좌 생성 메서드 */
	void make();
	/** 
     * 금액을 입금하는 메서드.
     * @param amount 입금할 금액.
     */
	void deposit(int amount);
	/**
     * 금액을 출금하는 메서드.
     * @param amount 출금할 금액.
     */
	void withdraw(int amount);
	/** 현재 잔액을 조회하는 메서드 */
	void displayBalance();
}
