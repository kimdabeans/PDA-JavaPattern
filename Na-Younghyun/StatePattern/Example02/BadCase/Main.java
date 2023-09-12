package StatePattern.Example02.BadCase;

public class Main {

  public static void main(String[] args) {

    int initialGumballCount = 5;

    GumballMachine gumballMachine = new GumballMachine(initialGumballCount);
    System.out.println("Gumball Machine 게임을 시작합니다.");

    gumballMachine.insertQuarter();
    gumballMachine.turnCrank();
    gumballMachine.dispense();

    int remainingGumballs = gumballMachine.getCount();
    int currentState = gumballMachine.getState();

    System.out.println("현재 알맹이 개수: " + remainingGumballs);
    System.out.println("현재 상태: " + translateState(currentState));
  }

  private static String translateState(int stateCode) {
    switch (stateCode) {
      case GumballMachine.SOLD_OUT:
        return "알맹이 매진 상태";
      case GumballMachine.NO_QUARTER:
        return "동전 없음 상태";
      case GumballMachine.HAS_QUARTER:
        return "동전 있음 상태";
      case GumballMachine.SOLD:
        return "알맹이 판매 상태";
      default:
        return "알 수 없는 상태";
    }
  }
}

