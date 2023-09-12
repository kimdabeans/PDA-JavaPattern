package Adapter;

/**
 * Client 클래스는 Print 인터페이스를 이용하여 출력 기능을 사용하여 동작을 test합니다.
 */
public class Client {

    public static void main(String[] args) {
        Print p = new PrintBanner("hello");

        p.printWaek();
        p.pirntStrong();
    }
}