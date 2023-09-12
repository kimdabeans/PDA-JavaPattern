package FactoryPattern.Example01.After;

/**
 *
 * <p>이 클래스는 Factory 클래스를 상속하여 이벤트 티켓을 생성하고 등록하는 팩토리를 나타냅니다.</p>
 *
 * @author younghyun
 * @version 1.0
 * @see Factory
 */
public class TicketFactory extends Factory {

  /**
   * 제품을 생성하는 메서드.
   *
   * @param eventName 이벤트 이름
   * @return 생성된 제품 인스턴스
   */
  @Override
  protected Product createProduct(String eventName) {
    return new Ticket(eventName);
  }

  /**
   * 제품을 등록하는 메서드.
   *
   * @param product 등록할 제품 인스턴스
   */
  @Override
  protected void registerProduct(Product product) {
    System.out.println(product + "을 등록했습니다.");
  }
}
