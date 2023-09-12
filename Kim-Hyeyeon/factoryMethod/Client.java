package factoryMethod;
/**
 * 클라이언트 클래스 - 메인 클래스.
 */
public class Client {
    public static void main(String[] args) {
    	performAccountOperations("Checking", "John", 5000, 2000, 4000);
    	System.out.println("=====================================");
        performAccountOperations("Saving", "Anna", 1000, 3000, 2000);
    }
    
    /**
     * 주어진 파라미터로 입출금을 수행하는 메서드.
     *
     * @param type 계좌의 타입.
     * @param name 계좌 소유자의 이름.
     * @param initialBalance 초기 잔액
     * @param depositAmount 입금할 금액
     * @param withdrawAmount 출금할 금액
     */
    private static void performAccountOperations(String type, String name, int initialBalance, int depositAmount, int withdrawAmount) {
    	Account account = AccountFactory.createAccount(type, name, initialBalance);
        account.make();
        account.displayBalance();
        account.deposit(depositAmount);
        account.displayBalance();
        account.withdraw(withdrawAmount);
        account.displayBalance();
    }
}
