package StatePattern.Example01;

/**
 * 상태(State) 패턴에서 사용되는 인터페이스.
 * 여러 상태를 나타내는 클래스들은 이 인터페이스를 구현하여 다양한 상태 변화와 동작을 정의합니다.
 *
 * @author younghyun
 * @version 1.0
 */
public interface State {
  /**
   * 시간에 따른 상태 변화를 처리하는 메서드입니다.
   *
   * @param context 상태 변화를 수행하는 컨텍스트(Context)
   * @param hour 현재 시간 (0부터 23까지의 시간)
   */
  void doClock(Context context, int hour);

  /**
   * 금고 사용 동작을 처리하는 메서드입니다.
   *
   * @param context 상태 변화를 수행하는 컨텍스트(Context)
   */
  void doUse(Context context);

  /**
   * 비상벨 동작을 처리하는 메서드입니다.
   *
   * @param context 상태 변화를 수행하는 컨텍스트(Context)
   */
  void doAlarm(Context context);

  /**
   * 일반 통화 동작을 처리하는 메서드입니다.
   *
   * @param context 상태 변화를 수행하는 컨텍스트(Context)
   */
  void doPhone(Context context);
}