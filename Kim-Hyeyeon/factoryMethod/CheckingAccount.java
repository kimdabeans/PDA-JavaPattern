package factoryMethod;

public class CheckingAccount implements Account{
	private String name;
	private int balance;
	
	public CheckingAccount(String name, int balance) {
		this.name= name;
		this.balance = balance;
	}
	
	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		System.out.println(name + " deposit " + balance + "won");
	}

	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		System.out.println(name + " withdraw " + balance + "won" );
	}

	@Override
    public void make() {
        System.out.println("Making a Checking Account");
    }
}
