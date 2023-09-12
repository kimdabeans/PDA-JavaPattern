package FactoryPattern.Example02.After;

/**
 * 케이크를 나타내는 추상 클래스입니다.
 */
public abstract class Cake {

  /**
   * 케이크를 준비합니다.
   */
  public abstract void prepare();

  /**
   * 케이크를 꾸미고 장식합니다.
   */
  public abstract void decorate();

  /**
   * 케이크를 제공합니다.
   */
  public abstract void serve();

  /**
   * 케이크의 이름을 반환합니다.
   *
   * @return 케이크의 이름
   */
  public abstract String getName();
}
