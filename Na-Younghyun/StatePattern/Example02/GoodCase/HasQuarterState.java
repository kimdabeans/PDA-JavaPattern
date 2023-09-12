package StatePattern.Example02.GoodCase;

/**
 * HasQuarterState 클래스는 Gumball Machine의 '동전 있음' 상태를 나타냅니다.
 */
public class HasQuarterState implements State {

  GumballMachine gumballMachine;

  /**
   * HasQuarterState 객체를 생성합니다.
   *
   * @param gumballMachine Gumball Machine 객체
   */
  public HasQuarterState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("동전은 이미 있습니다. 손잡이를 돌려주세요.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("동전이 반환됩니다.");
    gumballMachine.setState(gumballMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    System.out.println("손잡이를 돌렸습니다.");
    gumballMachine.setState(gumballMachine.getSoldState());
  }

  @Override
  public void dispense() {
    System.out.println("알맹이가 나갈 수 없습니다.");
  }
}
