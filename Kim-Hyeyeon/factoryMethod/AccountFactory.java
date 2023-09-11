package factoryMethod;

public class AccountFactory {
    public static Account createAccount(String type, String name, int balance) {
        if (type.equals("Checking")) {
            return new CheckingAccount(name, balance);
        } else {
            return new SavingAccount(name, balance);
        }
    }
}
