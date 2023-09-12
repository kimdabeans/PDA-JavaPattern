package FactoryPattern.Example01.After;

/**
 * Main: 메인 클래스.
 */
public class Main {
  /**
   * 프로그램의 진입점.
   *
   * @param args 커맨드 라인 인수 (사용하지 않음)
   */
  public static void main(String[] args) {
    Factory factory = new TicketFactory();
    Product ticket1 = factory.create("이벤트1");
    Product ticket2 = factory.create("이벤트2");
    Product ticket3 = factory.create("이벤트3");

    ticket1.use();
    ticket2.use();
    ticket3.use();
  }
}
