/**
 * Singleton class
 * 이 클래스는 싱글톤 디자인 패턴을 구현한 예제입니다.
 * 싱글톤 패턴은 클래스의 인스턴스가 하나만 생성되고, 이후에는 그 인스턴스를 공유하여 사용하는 디자인 패턴입니다.
 *
 * @author kim sungbum
 */
public class Singleton {

    // 싱글톤 인스턴스를 저장하기 위한 프라이빗 정적 변수
    private static Singleton instance = null;

    // 프라이빗 생성자로 외부에서의 인스턴스 생성을 방지
    private Singleton() {
    }

    /**
     * 싱글톤 인스턴스를 반환하는 메서드입니다.
     * 인스턴스가 이미 생성되어 있는 경우에는 그 인스턴스를 반환하고, 그렇지 않은 경우에는 새로운 인스턴스를 생성하여 반환합니다.
     *
     * @return 싱글톤 인스턴스
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
