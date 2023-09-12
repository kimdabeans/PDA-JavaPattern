package singleton;
/**
 * 이 클래스는 싱글톤 디자인 패턴을 구현한 예제입니다.
 * 싱글톤 패턴은 클래스의 인스턴스가 하나만 생성되도록 보장하는 패턴입니다.
 */

public class Singleton {
    private static Singleton singleton = new Singleton();

    /**
     * 프라이빗 생성자로 외부에서의 인스턴스 생성을 방지합니다.
     * 이 생성자는 딱 한 번 호출되며, 인스턴스가 생성될 때 실행됩니다.
     */
    private Singleton() {
        System.out.println("인스턴스 생성");
    }

    /**
     * 싱글톤 인스턴스를 반환하는 정적 메서드입니다.
     *
     * @return 싱글톤 인스턴스
     */
    public static Singleton getInstance() {
        return singleton;
    }
}