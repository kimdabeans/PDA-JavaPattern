package FactoryMethodPattern;

/**
 * 계좌(Account)를 나타내는 일반적인 클래스입니다.
 */
class Account {
    /**
     * 계좌를 개설합니다.
     */
    void open() {}

    /**
     * 계좌에 돈을 입금합니다.
     */
    void deposit() {}

    /**
     * 계좌에서 돈을 출금합니다.
     */
    void withdraw() {}

    /**
     * 계좌를 닫습니다.
     */
    void close() {}
}