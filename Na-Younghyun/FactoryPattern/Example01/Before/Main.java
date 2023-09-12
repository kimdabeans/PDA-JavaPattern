package FactoryPattern.Example01.Before;

/**
 * Factory Pattern을 사용하지 않는 경우, 제품(티켓)을 직접 생성하고 사용하는 방식입니다.
 * 이로 인해 제품 생성 및 관리 코드가 클라이언트 코드에 섞여 있어, 복잡하고 유지보수가 어렵다는 단점이 있습니다.
 */
public class Main {
  public static void main(String[] args) {

    Product ticket1 = new Ticket("이벤트1");
    Product ticket2 = new Ticket("이벤트2");
    Product ticket3 = new Ticket("이벤트3");

    ticket1.use();
    ticket2.use();
    ticket3.use();
  }
}
