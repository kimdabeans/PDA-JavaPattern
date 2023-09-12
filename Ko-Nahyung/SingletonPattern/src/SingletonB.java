/**
 * SingletonA 클래스에서 자원 낭비가 발생하는 단점을 보완한 Singleton 패턴입니다.
 */
public class SingletonB {
	/**
	 * SingletonB 클래스의 인스턴스를 나타내는 정적 변수입니다.
	 */
	private static SingletonB singletonB;
	
	/**
	 * SingletonB 클래스의 생성자로, 생성되었음을 콘솔에 출력합니다.
	 * private 생성자로, Singleton Pattern의 특징을 갖습니다.
	 */
	private SingletonB() {
		System.out.println("Singleton B 인스턴스를 생성했습니다.");
	}
	
	/**
	 * SingletonB 클래스의 인스턴스를 반환합니다.
	 * 
	 * @return 기존에 생성되어있던 SingletonB 인스턴스 또는 새롭게 생성한 인스턴스를 반환합니다.
	 */
	public static SingletonB getInstance() {
		if (singletonB == null) {
			singletonB = new SingletonB();
		}
	    return singletonB; 
	}
}
