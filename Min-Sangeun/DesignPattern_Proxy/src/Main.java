public class Main {
    public static void main(String[] args) {
        
    	BankAccountProxy uncreatedAccountProxy = new BankAccountProxy("password123");
        uncreatedAccountProxy.deposit(100); // 계좌가 아직 생성되지 않아 적용되지 않는다. 
        System.out.println("잔액: " + uncreatedAccountProxy.getBalance() + "원");

        BankAccountProxy accountProxy = new BankAccountProxy("password123");
        accountProxy.createAccount();
        accountProxy.deposit(150);
        System.out.println("잔액: " + accountProxy.getBalance() + "원");
        accountProxy.withdraw(50);
        System.out.println("출금 후 잔액: " + accountProxy.getBalance() + "원");
        
        accountProxy.createAccount();
        
    }
}
