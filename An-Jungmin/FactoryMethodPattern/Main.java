package FactoryMethodPattern;


/**
 * 은행 계좌 생성과 작업을 데모하는 메인 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        Bank bankA = new Shinhan();
        Bank bankB = new KB();

        Account savingsAccountA = bankA.createAccount("저축");
        Account checkingAccountB = bankB.createAccount("수표");

        if (savingsAccountA != null) {
            System.out.println("저축 계좌 (Shinhan) 생성 및 작업 수행.");
        } else {
            System.out.println("저축 계좌 (Shinhan) 생성 실패.");
        }

        if (checkingAccountB != null) {
            System.out.println("수표 계좌 (KB) 생성 및 작업 수행.");
        } else {
            System.out.println("수표 계좌 (KB) 생성 실패.");
        }
    }
}