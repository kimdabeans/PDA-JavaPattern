package FactoryPattern.Example01.After;

/**
 * Product 클래스: 제품을 나타내는 추상 클래스.
 *
 * <p>이 클래스는 제품을 나타내는 추상 클래스로, 모든 제품 클래스는 이 클래스를 상속받는다.</p>
 *
 * @author younghyun
 * @version 1.0
 */
public abstract class Product {
  /**
   * 제품을 사용하는 메서드.
   */
  public abstract void use();
}


