package FactoryMethodPattern2;
/**
 * 전기 자동차를 나타내는 클래스입니다. {@link Vehicle} 인터페이스를 구현하여
 * {@link Vehicle#startEngine()} 메서드를 오버라이드하여 전기 자동차의 엔진을 시작합니다.
 *
 * @author Cho Hayoung
 */
public class ElectricCar implements Vehicle {

    /**
     * 전기 자동차의 엔진을 버튼을 눌러 시작합니다.
     */
    @Override
    public void startEngine() {
        System.out.println("전기 자동차의 엔진을 버튼을 눌러 시작합니다...");
    }

}
