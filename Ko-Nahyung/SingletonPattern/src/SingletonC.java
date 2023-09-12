/**
 * SingletonB 클래스에서 멀티스레드 환경 동작을 고려한 Singleton 패턴입니다.
 */
public class SingletonC {
	/**
	 * SingletonC 클래스의 인스턴스를 나타내는 정적 변수입니다.
	 */
    private static SingletonC singletonC;

	/**
	 * SingletonC 클래스의 생성자로, 생성되었음을 콘솔에 출력합니다.
	 * private 생성자로, Singleton Pattern의 특징을 갖습니다.
	 */
    private SingletonC() {
    	System.out.println("Singleton C 인스턴스를 생성했습니다.");
    }

	/**
	 * SingletonC 클래스의 인스턴스를 반환합니다.
	 * synchronized를 통해 멀티스레드 환경에서 동작 시, 2개 이상의 인스턴스가 생성되는 것을 방지합니다.
	 * 
	 * @return 기존에 생성되어있던 SingletonC 인스턴스 또는 새롭게 생성한 인스턴스를 반환합니다.
	 */
    public static synchronized SingletonC getInstance() {
        if (singletonC == null) {
        	singletonC = new SingletonC();
        }
        return singletonC;
    }
}
