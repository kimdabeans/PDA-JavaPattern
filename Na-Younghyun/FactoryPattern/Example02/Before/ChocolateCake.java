package FactoryPattern.Example02.Before;

/**
 * {@code ChocolateCake} 클래스는 초콜릿 케이크를 나타내는 구체적인 케이크 클래스입니다.
 * {@link Cake} 추상 클래스를 상속하여 구현되었으며, 초콜릿 케이크에 특화된 기능을 제공합니다.
 */
public class ChocolateCake extends Cake {

  /**
   * 초콜렛 케이크의 준비 과정을 구현합니다.
   * 예를 들어, 초콜렛을 추가하는 과정이 여기에 포함될 수 있습니다.
   */
  @Override
  public void prepare() {
    // 케이크를 만드는 구체적인 과정을 구현합니다.
  }

  /**
   * 초콜렛 케이크를 꾸미는 과정을 구현합니다.
   * 장식품을 놓는 과정등이 여기에 포함될 수 있습니다.
   */
  @Override
  public void decorate() {
    // 케이크를 꾸미는 구체적인 과정을 구현합니다.
  }

  /**
   * 초콜렛 케이크를 서빙하는 과정을 구현합니다.
   * 고객에게 제공하기 전에 수행해야 할 서빙 관련 작업이 여기에 포함될 수 있습니다.
   */
  @Override
  public void serve() {
    // 케이크를 제공하는 구체적인 과정을 구현합니다.
  }

  @Override
  public String getName() {
    return "초콜릿 케이크";
  }
}

