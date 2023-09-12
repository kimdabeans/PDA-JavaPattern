package StatePattern.Example02.GoodCase;

public class Main {

  public static void main(String[] args) {

    int initialGumballCount = 5;

    GumballMachine gumballMachine = new GumballMachine(initialGumballCount);
    System.out.println("Gumball Machine 게임을 시작합니다.");

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.dispense();

    int remainingGumballs = gumballMachine.getCount();
    State currentState = gumballMachine.getState();

    System.out.println("현재 알맹이 개수: " + remainingGumballs);
    System.out.println("현재 상태: " + translateState(currentState));
  }

  private static String translateState(State state) {
    if (state instanceof SoldState) {
      return "알맹이 판매 상태";
    } else if (state instanceof SoldOutState) {
      return "알맹이 매진 상태";
    } else if (state instanceof NoQuarterState) {
      return "동전 없음 상태";
    } else if (state instanceof HasQuarterState) {
      return "동전 있음 상태";
    } else {
      return "알 수 없는 상태";
    }
  }
}
