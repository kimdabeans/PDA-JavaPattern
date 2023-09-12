package StatePattern.Example02.GoodCase;

/**
 * State 인터페이스는 Gumball Machine의 상태를 정의하는 메서드를 제공합니다.
 */
public interface State {

  /**
   * 동전을 투입합니다.
   */
  void insertQuarter();

  /**
   * 동전을 반환합니다.
   */
  void ejectQuarter();

  /**
   * 손잡이를 돌립니다.
   */
  void turnCrank();

  /**
   * 알맹이를 내보냅니다.
   */
  void dispense();
}