package FactoryMethodPattern;

/**
 * 특정 유형의 계좌를 생성하는 은행을 나타내는 추상 클래스입니다.
 */
abstract class Bank {
    /**
     * 주어진 유형에 따라 특정 유형의 계좌를 생성합니다.
     *
     * @param type 생성할 계좌의 유형
     * @return 특정 계좌 유형의 인스턴스
     */
    Account createAccount(String type) {
        Account account;

        account = createSpecificAccount(type);

        account.open();
        account.deposit();
        account.withdraw();
        account.close();

        return account;
    }

    /**
     * 주어진 유형에 따라 특정 유형의 계좌를 생성합니다.
     *
     * @param type 생성할 계좌의 유형
     * @return 특정 계좌 유형의 인스턴스
     */
    protected abstract Account createSpecificAccount(String type);
}
