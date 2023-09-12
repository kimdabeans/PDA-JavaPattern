package StatePattern.Example02.BadCase;

/**
 * GumballMachine 클래스는 Gumball Machine을 나타내며 동전을 투입하여 알맹이를 판매하는 기능을 제공합니다.
 */
public class GumballMachine {

  final static int SOLD_OUT = 0;  // 알맹이 매진 상태
  final static int NO_QUARTER = 1;  // 동전 없음 상태
  final static int HAS_QUARTER = 2;  // 동전 있음 상태
  final static int SOLD = 3;  // 알맹이 판매 상태

  int state = SOLD_OUT;  // 현재 상태
  int count = 0;  // 알맹이 개수

  /**
   * GumballMachine 객체를 생성합니다.
   *
   * @param count 초기 알맹이 개수
   */
  public GumballMachine(int count) {
    this.count = count;
    if (count > 0) {
      state = NO_QUARTER;
    }
  }

  /**
   * 동전을 투입합니다.
   */
  public void insertQuarter() {
    if (state == HAS_QUARTER) {
      System.out.println("동전이 이미 들어있습니다.");
    } else if (state == SOLD_OUT) {
      System.out.println("매진되었습니다.");
    } else if (state == SOLD) {
      System.out.println("캡슐이 나가고 있습니다. 기다려 주세요.");
    } else if (state == NO_QUARTER) {
      state = HAS_QUARTER;
      System.out.println("동전이 투입되었습니다.");
    }
  }

  /**
   * 동전을 반환합니다.
   */
  public void ejectQuarter() {
    if (state == HAS_QUARTER) {
      System.out.println("동전이 반환됩니다.");
      state = NO_QUARTER;
    } else if (state == NO_QUARTER) {
      System.out.println("투입한 동전이 없습니다.");
    } else if (state == SOLD) {
      System.out.println("이미 손잡이를 돌렸습니다. 동전이 반환되지 않습니다.");
    } else if (state == SOLD_OUT) {
      System.out.println("동전을 투입하지 않았습니다. 반환할 동전이 없습니다.");
    }
  }

  /**
   * 손잡이를 돌립니다.
   */
  public void turnCrank() {
    if (state == HAS_QUARTER) {
      System.out.println("손잡이를 돌렸습니다.");
      state = SOLD;
      dispense();  // 알맹이 내보내기
    } else if (state == NO_QUARTER) {
      System.out.println("동전을 투입하지 않았습니다. 손잡이를 돌릴 수 없습니다.");
    } else if (state == SOLD) {
      System.out.println("손잡이는 한 번만 돌려주세요.");
    } else if (state == SOLD_OUT) {
      System.out.println("알맹이가 매진되어 손잡이를 돌릴 수 없습니다.");
    }
  }

  /**
   * 알맹이를 내보냅니다.
   */
  public void dispense() {
    if (state == SOLD) {
      System.out.println("알맹이가 나갑니다.");
      count--;
      if (count == 0) {
        System.out.println("더 이상 알맹이가 없습니다.");
        state = SOLD_OUT;
      } else {
        state = NO_QUARTER;
      }
    } else if (state == NO_QUARTER) {
      System.out.println("동전을 투입하지 않았습니다. 알맹이를 내보낼 수 없습니다.");
    } else if (state == HAS_QUARTER) {
      System.out.println("손잡이를 돌리지 않았습니다. 알맹이를 내보낼 수 없습니다.");
    } else if (state == SOLD_OUT) {
      System.out.println("알맹이가 매진되었습니다. 알맹이를 내보낼 수 없습니다.");
    }
  }

  /**
   * 알맹이 개수를 얻습니다.
   *
   * @return 현재 알맹이 개수
   */
  public int getCount() {
    return count;
  }

  /**
   * 현재 상태를 얻습니다.
   *
   * @return 현재 상태
   */
  public int getState() {
    return state;
  }
}
