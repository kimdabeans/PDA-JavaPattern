/**
 * 비효율적인 방식으로 구현된 신호등 클래스입니다.
 * 이 클래스는 각 신호등 상태를 정수 상수로 표현하고, 상태 전환에 대한 조건문을 사용하여 동작합니다.
 */
public class InefficientTrafficLight {
    /**
     * 빨간 불 상태를 나타내는 정수 상수입니다.
     */
    public static final int RED = 0;

    /**
     * 초록 불 상태를 나타내는 정수 상수입니다.
     */
    public static final int GREEN = 1;

    /**
     * 노란 불 상태를 나타내는 정수 상수입니다.
     */
    public static final int YELLOW = 2;

    private int currentState = RED;

    /**
     * 현재 신호등 상태를 변경합니다. 빨간 불에서 초록 불, 초록 불에서 노란 불,
     * 노란 불에서 다시 빨간 불로 상태를 변경하며 각 상태에서 특정 동작을 수행합니다.
     */
    public void change() {
        if (currentState == RED) {
            System.out.println("빨간 불 - 정지");
            // 빨간 불 상태에서의 동작을 수행
            // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
            currentState = GREEN;
        } else if (currentState == GREEN) {
            System.out.println("초록 불 - 진행");
            // 초록 불 상태에서의 동작을 수행
            // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
            currentState = YELLOW;
        } else if (currentState == YELLOW) {
            System.out.println("노란 불 - 경고");
            // 노란 불 상태에서의 동작을 수행
            // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
            currentState = RED;
        }
    }

    /**
     * 주 애플리케이션 진입점입니다. 이 메소드에서는 {@link InefficientTrafficLight} 객체를 생성하고,
     * 상태 변경을 여러 번 반복하여 신호등 동작을 시뮬레이션합니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        InefficientTrafficLight trafficLight = new InefficientTrafficLight();

        // 상태 변경을 여러 번 반복하여 신호등 동작 시뮬레이션
        for (int i = 0; i < 5; i++) {
            trafficLight.change();
        }
    }
}
