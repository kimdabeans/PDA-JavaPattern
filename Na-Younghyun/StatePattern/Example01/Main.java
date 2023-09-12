package StatePattern.Example01;

/**
 * State 패턴 예제의 메인 클래스입니다.
 * 프로그램을 실행하면 SafeFrame을 생성하고 시간을 시뮬레이션하여
 * 상태(State) 변화를 관찰하는 역할을 합니다.
 */
public class Main {
  /**
   * 프로그램의 진입점입니다.
   *
   * @param args 커맨드 라인 인수 (사용하지 않음)
   */
  public static void main(String[] args) {
    // SafeFrame을 생성하고 시간 시뮬레이션을 수행합니다.
    SafeFrame frame = new SafeFrame("State Sample");
    while (true) {
      for (int hour = 0; hour < 24; hour++) {
        frame.setClock(hour);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // 스레드 인터럽트 예외 처리
        }
      }
    }
  }
}

