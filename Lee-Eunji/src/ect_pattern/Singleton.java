package ect_pattern;

/**
 * Singleton 디자인 패턴을 구현한 클래스입니다.
 * 이 클래스는 오직 하나의 인스턴스만을 생성하고 제공합니다.
 */
public class Singleton{
    private static Singleton singleton = new Singleton();

    /**
     * 생성자는 외부에서 호출하지 못하게 private으로 지정되어 있습니다.
     * 인스턴스 생성 시 메시지가 출력됩니다.
     */
    private Singleton(){
        System.out.println("인스턴스를 생성했습니다.");
    }

    /**
     * Singleton 인스턴스를 가져오는 정적 메소드입니다.
     * 이미 생성된 인스턴스를 반환합니다.
     *
     * @return Singleton 인스턴스
     */
    public static Singleton getInstance(){
        return singleton;
    }
}