package FactoryMethodPattern2;

/**
 * Bicycle 클래스는 Vehicle 인터페이스를 구현하는 클래스입니다.
 * Bicycle은 엔진을 가지지 않으므로 startEngine() 메서드는 엔진을 시작하지 않음을 출력합니다.
 * 
 * @author Cho hayoung
 */
public class Bicycle implements Vehicle {
	
	@Override
	public void startEngine() {
		System.out.println("엔진을 가지지 않는 Bicycle입니다.");
	}
}
