package factoryMethod;
/**
 * 적금 계좌 클래스.
 */

public class SavingAccount implements Account {
	private String name;
	private int balance;
	/**
     * 적금 계좌 생성자.
     * @param name 계좌 소유자 이름.
     * @param balance 초기 잔액.
     */
	public SavingAccount(String name, int  balance) {
		this.name= name;
		this.balance = balance;
	}
	
	@Override
	public void deposit(int amount) {
		balance += amount;
		System.out.println("Saving " + amount + " won.");
	}

	@Override
	public void withdraw(int amount) {
		System.out.println("Withdraw " + amount + " won.");
		System.out.println("It's Saving Account. You can't withdraw it.");
	}
	
	@Override
    public void make() {
        System.out.println("Making a Saving Account!");
    }
	
	@Override
    public void displayBalance() {
        System.out.println(name + "'s Current balance: " + balance + " won.");
    }
}
