package factoryMethod;

/**
 * Hamburger 추상 클래스는 햄버거 객체를 나타내며, 서빙 메소드를 제공합니다.
 */
abstract class Hamburger {
    /**
     * 햄버거를 서빙하는 추상 메소드입니다.
     * 구체적인 구현 클래스에서 이 메소드를 구현해야 합니다.
     */
    public abstract void serve();
}