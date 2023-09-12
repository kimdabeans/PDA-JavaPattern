package FactoryPattern.Example02.After;

/**
 * 케이크를 주문하고 생성하는 케이크 가게 클래스입니다.
 */
public class CakeStore {
  CakeFactory factory;

  public CakeStore(CakeFactory factory) {
    this.factory = factory;
  }

  /**
   * 주어진 타입의 케이크를 주문하고 생성합니다.
   *
   * @param type 주문할 케이크 타입
   * @return 주문된 케이크 객체
   */
  public Cake orderCake(String type) {
    Cake cake;

    cake = factory.createCake(type);

    cake.prepare();
    cake.decorate();
    cake.serve();

    return cake;
  }
}

