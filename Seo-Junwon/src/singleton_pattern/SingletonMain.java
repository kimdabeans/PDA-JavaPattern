package singleton_pattern;
/**
 * <p>
 * 구현한 5가지의 싱글톤 패턴을 테스트할 수 있는 메인 클래스이다.<br>
 * 싱글톤 패턴을 통해 여러 인스턴스가 같은 주소를 가지고 있음을 확인할 수 있다. 
 * </p>
 * @author 서준원
 *
 */
public class SingletonMain {
	
	public static void main(String[] args) {

        // Singleton.getInstance() 를 통해 싱글톤 객체를 각기 변수마다 받아와도 똑같은 객체 주소를 가리킨다
        SingletonEager singletonEager1 = SingletonEager.getInstance();
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazyHolder singletonLazyHolder1 = SingletonLazyHolder.getInstance();
        SingletonStaticBlock singletonStaticBlock1 = SingletonStaticBlock.getInstance();

        System.out.println(singletonEager1.toString()); 
        System.out.println(singletonLazy1.toString()); 
        System.out.println(singletonLazyHolder1.toString()); 
        System.out.println(singletonStaticBlock1.toString()); 

        System.out.println("-----------------------------------------------");
        
        SingletonEager singletonEager2 = SingletonEager.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        SingletonLazyHolder singletonLazyHolder2 = SingletonLazyHolder.getInstance();
        SingletonStaticBlock singletonStaticBlock2 = SingletonStaticBlock.getInstance();

        
        System.out.println(singletonEager2.toString()); 
        System.out.println(singletonLazy2.toString()); 
        System.out.println(singletonLazyHolder2.toString()); 
        System.out.println(singletonStaticBlock2.toString()); 
        

    }
}

