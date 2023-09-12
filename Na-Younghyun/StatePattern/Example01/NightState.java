package StatePattern.Example01;

/**
 * NightState 클래스: 야간 상태를 나타내는 클래스.
 * 상태 패턴에서 구체적인 상태 중 하나를 나타냅니다.
 *
 * @see DayState
 */
public class NightState implements State {
  private static NightState singleton = new NightState();

  private NightState() {
  }

  /**
   * NightState의 싱글톤 인스턴스를 반환합니다.
   *
   * @return NightState의 싱글톤 인스턴스
   */
  public static State getInstance() {
    return singleton;
  }

  @Override
  public void doClock(Context context, int hour) {
    if (9 <= hour && hour < 17) {
      context.changeState(DayState.getInstance());
    }
  }

  @Override
  public void doUse(Context context) {
    context.callSecurityCenter("비상: 야간 금고 사용!");
  }

  @Override
  public void doAlarm(Context context) {
    context.callSecurityCenter("비상벨(야간)");
  }

  @Override
  public void doPhone(Context context) {
    context.recordLog("야간 통화 녹음");
  }

  @Override
  public String toString() {
    return "[야간]";
  }

}

