package FactoryPattern.Example01.After;

/**
 * Factory 클래스: 제품을 생성하고 등록하는 클래스
 *
 * <p>이 클래스는 제품을 생성하고 등록하는 추상 팩토리를 나타냅니다.</p>
 *
 * @author younghyun
 * @version 1.0
 * @see TicketFactory
 */
public abstract class Factory {

  /**
   * 제품을 생성하고 등록하는 메서드
   *
   * @param owner 소유자 정보
   * @return 생성된 제품 인스턴스
   */
  public final Product create(String owner) {
    Product p = createProduct(owner);
    registerProduct(p);
    return p;
  }

  /**
   * 제품을 생성하는 메서드
   *
   * @param owner 소유자 정보
   * @return 생성된 제품 인스턴스
   */
  protected abstract Product createProduct(String owner);

  /**
   * 제품을 등록하는 메서드
   *
   * @param product 등록할 제품 인스턴스
   */
  protected abstract void registerProduct(Product product);
}
