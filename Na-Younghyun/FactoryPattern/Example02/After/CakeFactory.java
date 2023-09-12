package FactoryPattern.Example02.After;

/**
 * 케이크를 생성하는 공장 클래스입니다.
 */
public class CakeFactory {

  /**
   * 주어진 타입에 따라 케이크 객체를 생성합니다.
   *
   * @param type 생성할 케이크 타입
   * @return 생성된 케이크 객체
   */
  public Cake createCake(String type) {
    Cake cake = null;

    if (type.equals("chocolate")) {
      cake = new ChocolateCake();
    } else if (type.equals("vanilla")) {
      cake = new VanillaCake();
    } else if (type.equals("strawberry")) {
      cake = new StrawberryCake();
    }

    return cake;
  }
}

