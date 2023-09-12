package StatePattern.Example01;

/**
 * DayState 클래스: 주간 상태를 나타내는 클래스.
 * 상태 패턴에서 구체적인 상태 중 하나를 나타냅니다.
 * @author younghyun
 * @version 1.0
 */
public class DayState implements State {
  private static DayState singleton = new DayState();

  private DayState() {
  }

  /**
   * DayState의 싱글톤 인스턴스를 반환합니다.
   *
   * @return DayState의 싱글톤 인스턴스
   */
  public static State getInstance() {
    return singleton;
  }

  @Override
  public void doClock(Context context, int hour) {
    if (hour < 9 || 17 <= hour) {
      context.changeState(NightState.getInstance());
    }
  }

  @Override
  public void doUse(Context context) {
    context.recordLog("금고 사용(주간)");
  }

  @Override
  public void doAlarm(Context context) {
    context.callSecurityCenter("비상벨(주간)");
  }

  @Override
  public void doPhone(Context context) {
    context.callSecurityCenter("일반 통화(주간)");
  }

  @Override
  public String toString() {
    return "[주간]";
  }

}
