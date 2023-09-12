package StatePattern.Example02.GoodCase;

/**
 * SoldOutState 클래스는 Gumball Machine의 '알맹이 매진' 상태를 나타냅니다.
 */
public class SoldOutState implements State {

  GumballMachine gumballMachine;

  /**
   * SoldOutState 객체를 생성합니다.
   *
   * @param gumballMachine Gumball Machine 객체
   */
  public SoldOutState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("알맹이가 매진되어 동전을 투입할 수 없습니다.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("알맹이가 매진되어 동전을 반환할 수 없습니다.");
  }

  @Override
  public void turnCrank() {
    System.out.println("알맹이가 매진되어 손잡이를 돌릴 수 없습니다.");
  }

  @Override
  public void dispense() {
    System.out.println("알맹이가 매진되었습니다.");
  }
}

