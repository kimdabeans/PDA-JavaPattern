package StatePattern.Example02.GoodCase;

/**
 * NoQuarterState 클래스는 Gumball Machine의 '동전 없음' 상태를 나타냅니다.
 */
public class NoQuarterState implements State {

  GumballMachine gumballMachine;

  /**
   * NoQuarterState 객체를 생성합니다.
   *
   * @param gumballMachine Gumball Machine 객체
   */
  public NoQuarterState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("동전이 투입되었습니다.");
    gumballMachine.setState(gumballMachine.getHasQuarterState());
  }

  @Override
  public void ejectQuarter() {
    System.out.println("동전을 투입하지 않았습니다. 반환할 동전이 없습니다.");
  }

  @Override
  public void turnCrank() {
    System.out.println("동전을 투입하지 않았습니다. 손잡이를 돌릴 수 없습니다.");
  }

  @Override
  public void dispense() {
    System.out.println("동전을 투입하지 않았습니다. 알맹이를 내보낼 수 없습니다.");
  }
}