package singleton;
/**
 * 이 클래스는 Singleton 클래스를 사용하는 예제를 제공합니다.
 * Singleton 클래스의 인스턴스를 두 번 이상 생성하려고 시도하고,
 * 그 결과를 출력합니다.
 */

public class Main {
    /**
     * Main 메서드는 프로그램의 진입점입니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        System.out.println("Start");

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj1 == obj2) {
            System.out.println("obj1 == obj2");
        } else {
            System.out.println("obj1 != obj2");
        }

        System.out.println("End");
    }
}