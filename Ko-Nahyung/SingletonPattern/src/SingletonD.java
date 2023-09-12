/**
 * SingletonC 클래스에서 synchronized를 통한 성능 저하를 고려한 Singleton 패턴입니다.
 */
public class SingletonD {
	
	/**
	 * SingletonD 클래스의 생성자로, 생성되었음을 콘솔에 출력합니다.
	 * private 생성자로, Singleton Pattern의 특징을 갖습니다.
	 */
    private SingletonD() {
    	System.out.println("Singleton D 인스턴스를 생성했습니다.");
    }
    
    /**
     * SingletonD 클래스 내부에 선언된 private static LazyHolder 클래스입니다.
     * 해당 클래스를 통해서 singletonD 인스턴스를 final로 선언하고 생성합니다.
     */
    private static class LazyHolder {
        private static final SingletonD singletonD = new SingletonD();
    }
    
	/**
	 * SingletonD 클래스의 인스턴스를 반환합니다.
	 * 
	 * @return LazyHolder의 singletonD를 참조하여 반환합니다.
	 */
    public static SingletonD getInstance() {
        return LazyHolder.singletonD;
    }
}
