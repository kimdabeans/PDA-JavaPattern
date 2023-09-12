package singleton_pattern;

/**
 * <p>
 * Lazy Holding 기법을 사용해 Singleton Pattern을 구현한 클래스이다.<br>
 * Holder 기법을 사용하면 클래스가 계속 메모리에 로드되지 않고, getInstance 메서드가 호출될 때만 로드된다.
 * </p>
 * @author 서준원
 */
public class SingletonLazyHolder {

	/**
     * 외부에서 인스턴스화를 방지하기 위해 생성자를 private으로 선언한다.
     */
    private SingletonLazyHolder() {}

    /**
     * static 내부 클래스인 SingleInstanceHolder 클래스를 통해 Singleton 인스턴스를 보관한다.
     */
    private static class SingleInstanceHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }

    /**
     * SingletonEager 클래스의 Instance를 가져오는 메서드 
     * 
     * @return : static final로 선언해둔 Instance ( 생성한 SingletonLazyHolder 객체 )
     */
    public static SingletonLazyHolder getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }
}

