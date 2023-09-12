package FactoryPattern.Example02.Before;

/**
 * 케이크를 주문하고 생성하는 케이크 가게 클래스입니다.
 * 이 클래스는 다양한 종류의 케이크를 주문하고 생성하는 기능을 제공합니다.
 * 주문된 케이크는 준비(prepare), 꾸미기(decorate), 서빙(serve) 단계를 거칩니다.
 */
public class CakeStore {

  /**
   * 주어진 케이크 타입에 해당하는 케이크 객체를 생성하여 반환합니다.
   *
   * @param type 주문할 케이크 타입 (예: "chocolate", "vanilla", "strawberry" 등)
   * @return 주문된 케이크 객체
   * @throws IllegalArgumentException 지원하지 않는 케이크 타입을 주문할 경우 발생
   */
  public Cake orderCake(String type) {
    Cake cake;

    if (type.equals("chocolate")) {
      cake = new ChocolateCake();
    } else if (type.equals("vanilla")) {
      cake = new VanillaCake();
    } else if (type.equals("strawberry")) {
      cake = new StrawberryCake();
    } else {
      throw new IllegalArgumentException("지원하지 않는 케이크 타입입니다: " + type);
    }

    // 케이크 주문 과정
    cake.prepare();
    cake.decorate();
    cake.serve();

    return cake;
  }
}

