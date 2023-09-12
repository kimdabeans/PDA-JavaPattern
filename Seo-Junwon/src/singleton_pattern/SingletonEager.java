package singleton_pattern;

/**
 * <p>
 * Eager Initialization을 활용해서 Singleton Pattern 구현한 클래스이다.<br>
 * static final 선언을 해두었기에 멀티 쓰레드 환경에서도 안전하다.  <br>
 * 생성자를 private로 선언하여 외부에서 new를 통해 사용할 수 없다.
 * </p>
 * @author 서준원
 *
 */
public class SingletonEager {
	
	private static final SingletonEager INSTANCE = new SingletonEager();

	/**
     * 외부에서 인스턴스화를 방지하기 위해 생성자를 private으로 선언한다.
     */
    private SingletonEager() {}

    /**
     * SingletonEager 클래스의 Instance를 가져오는 메서드 
     * 
     * @return : static final로 선언해둔 Instance ( 생성한 SingletonEager 객체 )
     */
    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}

