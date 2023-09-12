package commandPattern2.account;

/**
 * 출금 액션을 나타내는 클래스 (ConcreteImplementor)
 *
 * @author Lee Sohyeong
 */
public class WithdrawAction implements BankAccountAction {

    // 클래스의 유일한 인스턴스를 클래스 내에 static 필드로 저장을 한다.
    private static final WithdrawAction instance = new WithdrawAction();

    /**
     * 생성자를 private 으로 만든다.
     * 클래스 외부에서 new 키워드로 인스턴스를 더 찍어낼 수 없다.
     */
    private WithdrawAction() {}

    /**
     * 클래스의 유일한 인스턴스를 얻기 위한 클래스 메소드
     * @return 입금 액션 인스턴스
     */
    public static WithdrawAction getInstance() {
        return instance;
    }

    @Override
    public boolean execute(BankAccount account, int amount) {
        return account.withdraw(amount);
    }

    @Override
    public void undo(BankAccount account, int amount) {
        account.deposit(amount);
    }
}
