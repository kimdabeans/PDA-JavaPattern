package StatePattern.Example02.GoodCase;

/**
 * GumballMachine 클래스는 Gumball Machine의 상태와 동작을 관리합니다.
 * State 패턴을 사용하여 여러 상태를 효과적으로 관리하고 상태에 따라 동작을 처리합니다.
 */
public class GumballMachine {

  State soldState;
  State soldOutState;
  State noQuarterState;
  State hasQuarterState;

  State state = soldOutState;
  int count = 0;

  /**
   * GumballMachine 객체를 생성합니다.
   *
   * @param numberOfGumballs 초기 알맹이 개수
   */
  public GumballMachine(int numberOfGumballs) {

    soldState = new SoldState(this);
    soldOutState = new SoldOutState(this);
    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);

    this.count = numberOfGumballs;
    if (numberOfGumballs > 0) {
      state = noQuarterState;
    }
  }

  /**
   * 동전을 투입합니다.
   */
  public void insertQuarter() {
    state.insertQuarter();
  }

  /**
   * 동전을 반환합니다.
   */
  public void ejectQuarter() {
    state.ejectQuarter();
  }

  /**
   * 손잡이를 돌립니다.
   */
  public void turnCrank() {
    state.turnCrank();
  }

  /**
   * 알맹이를 내보냅니다.
   */
  public void dispense() {
    state.dispense();
  }

  /**
   * 알맹이가 나가는 동작을 처리합니다.
   */
  public void releaseBall() {
    System.out.println("알맹이가 나갑니다.");
    if (count != 0) {
      count -= 1;
    }
  }

  /**
   * 알맹이 개수를 반환합니다.
   *
   * @return 알맹이 개수
   */
  public int getCount() {
    return count;
  }

  /**
   * 알맹이 판매 상태를 설정합니다.
   *
   * @param state 알맹이 판매 상태
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * 알맹이 판매 상태를 반환합니다.
   * @return 알맹이 판매 상태
   */
  public State getState(){
    return state;
  }

  /**
   * 알맹이 판매 상태를 반환합니다.
   *
   * @return 알맹이 판매 상태
   */
  public State getSoldState() {
    return soldState;
  }

  /**
   * 알맹이 매진 상태를 반환합니다.
   *
   * @return 알맹이 매진 상태
   */
  public State getSoldOutState() {
    return soldOutState;
  }

  /**
   * 동전 없는 상태를 반환합니다.
   *
   * @return 동전 없는 상태
   */
  public State getNoQuarterState() {
    return noQuarterState;
  }

  /**
   * 동전 있음 상태를 반환합니다.
   *
   * @return 동전 있음 상태
   */
  public State getHasQuarterState() {
    return hasQuarterState;
  }
}
