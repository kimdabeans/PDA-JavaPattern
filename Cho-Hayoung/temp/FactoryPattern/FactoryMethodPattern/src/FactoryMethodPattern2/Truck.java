package FactoryMethodPattern2;

/**
 * 트럭을 나타내는 클래스입니다. {@link Vehicle} 인터페이스를 구현하여
 * {@link Vehicle#startEngine()} 메서드를 오버라이드하여 트럭의 대형 엔진을 시작합니다.
 *
 * @author Cho Hayoung
 */
public class Truck implements Vehicle {

    /**
     * 트럭의 대형 엔진을 시작합니다.
     */
    @Override
    public void startEngine() {
        System.out.println("트럭의 대형 엔진을 시작합니다...");
    }

}





