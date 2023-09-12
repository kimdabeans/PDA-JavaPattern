package FactoryMethodPattern2;

/**
 * 차량을 나타내는 인터페이스입니다. 모든 차량 클래스는 이 인터페이스를 구현하여
 * {@link #startEngine()} 메서드를 제공해야 합니다.
 * 
 * 차량은 엔진을 가지고 있으며, 이 메서드를 호출하여 엔진을 시작할 수 있습니다.
 * 구체적인 차량 클래스에서 엔진을 어떻게 시작하는지에 대한 구현이 제공되어야 합니다.
 *
 * @author Cho hayoung
 */
public interface Vehicle {

    /**
     * 차량의 엔진을 시작합니다.
     */
    public void startEngine();
}
