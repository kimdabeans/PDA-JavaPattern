/**
 * 교재에 소개된 방식으로 구현한 Singleton 패턴입니다.
 */
public class SingletonA {
	/**
	 * SingletonA 클래스의 인스턴스를 나타내는 정적 변수입니다.
	 */
	private static SingletonA singletonA = new SingletonA();
	
	/**
	 * SingletonA 클래스의 생성자로, 생성되었음을 콘솔에 출력합니다.
	 * private 생성자로, Singleton Pattern의 특징을 갖습니다.
	 */
	private SingletonA() {
		System.out.println("Singleton A 인스턴스를 생성했습니다.");
	}
	
	/**
	 * SingletonA 클래스의 인스턴스를 반환합니다.
	 * 
	 * @return 기존에 생성되어있던 singletonA 인스턴스를 반환합니다.
	 */
	public static SingletonA getInstance() {
		return singletonA;
	}
}
