package singleton;

/**
 * 싱글턴 패턴을 구현한 클래스. 이 클래스의 인스턴스는 한 개만 생성됩니다.
 */
public class Singleton {

    /**
     * 유일한 Singleton 인스턴스.
     */
    private static Singleton singleton = new Singleton();

    /**
     * Singleton 생성자.
     * <p>
     * 외부에서 인스턴스를 생성하는 것을 방지하기 위해 private 접근 제어자를 사용합니다.
     */
    private Singleton(){
        System.out.println("인스턴스를 생성했습니다");
    }

    /**
     * 유일한 Singleton 인스턴스를 반환하는 메서드.
     *
     * @return Singleton의 유일한 인스턴스
     */
    public static Singleton getInstance(){
        return singleton;
    }
}