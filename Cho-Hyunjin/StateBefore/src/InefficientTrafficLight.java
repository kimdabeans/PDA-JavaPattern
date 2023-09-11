public class InefficientTrafficLight {
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int YELLOW = 2;

    private int currentState = RED;

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

    public static void main(String[] args) {
        InefficientTrafficLight trafficLight = new InefficientTrafficLight();

        // 상태 변경을 여러 번 반복하여 신호등 동작 시뮬레이션
        for (int i = 0; i < 5; i++) {
            trafficLight.change();
        }
    }
}
