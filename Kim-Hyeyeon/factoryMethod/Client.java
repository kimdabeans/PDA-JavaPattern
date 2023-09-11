package factoryMethod;

public class Client {
    public static void main(String[] args) {
        Account johnsAccount = AccountFactory.createAccount("Checking", "John", 5000);
        johnsAccount.make();
        johnsAccount.deposit(2000);
        johnsAccount.withdraw(1000);

         Account annasAccount = AccountFactory.createAccount("Saving", "Anna", 10000);
         annasAccount.make();
         annasAccount.deposit(3000);
         annasAccount.withdraw(2000);
    }
}
