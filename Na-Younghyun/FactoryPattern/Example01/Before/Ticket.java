package FactoryPattern.Example01.Before;

/**
 * 티켓 클래스: 제품 클래스의 하위 클래스.
 */
public class Ticket extends Product {
  private String eventName;

  /**
   * 티켓 생성자.
   *
   * @param eventName 이벤트 이름
   */
  public Ticket(String eventName) {
    System.out.println(eventName + " 티켓을 발행합니다.");
    this.eventName = eventName;
  }

  /**
   * 티켓을 사용하는 메서드.
   */
  @Override
  public void use() {
    System.out.println(eventName + " 행사를 즐깁니다.");
  }

  /**
   * 객체를 문자열로 변환하는 메서드.
   *
   * @return 문자열 표현
   */
  @Override
  public String toString() {
    return "[Ticket: " + eventName + "]";
  }

  /**
   * 이벤트 이름을 반환하는 메서드.
   *
   * @return 이벤트 이름
   */
  public String getEventName() {
    return eventName;
  }
}
