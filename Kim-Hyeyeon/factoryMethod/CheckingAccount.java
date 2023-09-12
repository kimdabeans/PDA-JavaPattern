package factoryMethod;
/**
 * 예금 계좌 클래스.
 */
public class CheckingAccount implements Account{
	private String name;
	private int balance;
	/**
     * 예금 계좌 생성자.
     * @param name 계좌 소유자 이름.
     * @param balance 초기 잔액.
     */
	public CheckingAccount(String name, int balance) {
		this.name= name;
		this.balance = balance;
	}
	
	@Override
	public void deposit(int amount) {
		balance += amount;
		System.out.println("Deposit " + amount + " won.");
	}

	@Override
	public void withdraw(int amount) {
		 if (balance >= amount) {
			 balance -= amount;
	         System.out.println("Withdraw " + amount + " won.");
	     } else {
	    	 System.out.println("Withdraw " + amount + " won.");
	    	 System.out.println(name + " does not have enough balance to withdraw " + amount + " won.");
	     }
	}

	@Override
    public void make() {
        System.out.println("Making a Checking Account!");
    }
	
	@Override
	public void displayBalance() {
        System.out.println(name + "'s Current balance: " + balance + " won.");
    }

}
