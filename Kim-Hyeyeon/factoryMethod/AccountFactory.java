package factoryMethod;
/**
 * 계좌 유형에 따라 계좌 객체를 생성하는 팩토리 클래스.
 */
public class AccountFactory {
	
	/**
     * 주어진 계좌 유형에 따라 계좌 객체를 생성하고 반환.
     * @param type 계좌 유형 ("예금" 또는 "적금").
     * @param name 계좌 소유자 이름.
     * @param balance 초기 잔액.
     * @return 생성된 계좌 객체.
     */
    public static Account createAccount(String type, String name, int balance) {
        if (type.equals("Checking")) {
            return new CheckingAccount(name, balance);
        } else {
            return new SavingAccount(name, balance);
        }
    }
}
