package Singleton;

/**
 * description    : 여러가지 Singleton방법 중 LazyHolder Singleton패턴으로 synchronized같은 키워드 없이 thread-safe와 성능을 보장하는 방법<br>
 * packageName    : Singleton<br>
 * fileName       : Singleton<br>
 * author         : seoyun<br>
 * date           : 2023-09-11<br>
 */
public class Singleton {

    private Singleton() {}

    /**
     * static 내부 클래스 이용
     * 클래스가  로딩시 바로 메모리에 로드되지 않고 getInstance 메서드가 호출되어야 로드가 진행되는 과정을 통해 thread-safe와 성능 보장
     */
    private static class SingleInstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * 외부에서 객체를 생성할 수 있는 유일한 메소드
     * @return 유일한 인스턴스 반환
     */
    public static Singleton getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }
}
