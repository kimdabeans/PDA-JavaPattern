package factoryMethod;

public class SavingAccount implements Account {
	private String name;
	private int balance;
	
	public SavingAccount(String name, int  balance) {
		this.name= name;
		this.balance = balance;
	}
	
	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		System.out.println(name + " saving " + balance + "won");
	}

	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		System.out.println("You can't withdraw it.");
	}

	@Override
    public void make() {
        System.out.println("Making a Saving Account");
    }
}
