package FactoryMethodPattern2;

/**
 * Car 클래스는 Vehicle 인터페이스를 구현하는 클래스입니다.
 * Car는 엔진을 가지며, startEngine() 메서드를 호출하면 자동차 엔진을 시작합니다.
 * 
 * @author Cho hayoung
 */
public class Car implements Vehicle {

	@Override
	public void startEngine() {
		System.out.println("자동차 엔진을 시작합니다.");
	}
}
