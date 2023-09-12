package StatePattern.Example02.GoodCase;

/**
 * SoldState 클래스는 Gumball Machine의 '알맹이 판매' 상태를 나타냅니다.
 */
public class SoldState implements State {

  GumballMachine gumballMachine;

  /**
   * SoldState 객체를 생성합니다.
   *
   * @param gumballMachine Gumball Machine 객체
   */
  public SoldState(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("캡슐이 나가고 있습니다. 기다려 주세요.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("이미 캡슐을 뽑으셨습니다.");
  }

  @Override
  public void turnCrank() {
    System.out.println("손잡이는 한 번만 돌려주세요.");
  }

  @Override
  public void dispense() {
    gumballMachine.releaseBall();

    if (gumballMachine.getCount() > 0) {
      gumballMachine.setState(gumballMachine.getNoQuarterState());
    } else {
      System.out.println("더 이상 캡슐이 없습니다.");
      gumballMachine.setState(gumballMachine.getSoldOutState());
    }
  }
}
