package commandPattern2.account;

/**
 * 명령의 종류 (입금 또는 출금)를 나타내는 열거형
 */
public enum ActionType {

    /**
     * 입금 명령을 나타내는 열거 상수
     */
    DEPOSIT {
        @Override
        BankAccountAction getAction() {
            return DepositAction.getInstance();
        }
    },

    /**
     * 출금 명령을 나타내는 열거 상수
     */
    WITHDRAW {
        @Override
        BankAccountAction getAction() {
            return WithdrawAction.getInstance();
        }
    };

    /**
     * 열거 상수에 해당하는 BankAccountAction 객체를 반환한다.
     *
     * @return BankAccountAction 객체
     */
    abstract BankAccountAction getAction();
}
