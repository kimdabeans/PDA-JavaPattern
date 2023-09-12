package StatePattern.Example01;

/**
 * Context 인터페이스: 상태 전환과 관련된 메서드를 정의하는 인터페이스.
 * 다양한 상태 클래스와 함께 사용됩니다.
 */
public interface Context {
  /**
   * 시계를 설정하는 메서드.
   *
   * @param hour 설정할 시간
   */
  public abstract void setClock(int hour);

  /**
   * 상태를 변경하는 메서드.
   *
   * @param state 변경할 상태
   */
  public abstract void changeState(State state);

  /**
   * 보안 센터에 메시지를 전송하는 메서드.
   *
   * @param msg 전송할 메시지
   */
  public abstract void callSecurityCenter(String msg);

  /**
   * 로그를 기록하는 메서드.
   *
   * @param msg 기록할 메시지
   */
  public abstract void recordLog(String msg);
}
