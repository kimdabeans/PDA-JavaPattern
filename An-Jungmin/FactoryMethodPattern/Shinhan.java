package FactoryMethodPattern;

/**
 * 특정 계좌 유형을 생성하는 Bank A를 나타냅니다.
 */
class Shinhan extends Bank {
    /**
     * 주어진 유형에 따라 특정 유형의 계좌를 생성합니다.
     *
     * @param accountType 생성할 계좌의 유형
     * @return 특정 계좌 유형의 인스턴스
     */
    public Account createSpecificAccount(String accountType) {
        if (accountType.equals("저축")) {
            return new SavingAccount();
        } else if (accountType.equals("수표")) {
            return new CheckingAccount();
        } else if (accountType.equals("정기예금")) {
            return new FixedDepositAccount();
        } else {
            return null;
        }
    }
}
