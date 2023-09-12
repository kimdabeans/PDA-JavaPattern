/**
 * 주 애플리케이션 클래스입니다. 이 클래스는 신호등 동작 시뮬레이션을 수행합니다.
 */
public class Main {
    /**
     * 주 애플리케이션 진입점입니다. 이 메소드에서는 {@link TrafficLightContext} 객체를 생성하고,
     * 상태 변경을 여러 번 반복하여 신호등 동작을 시뮬레이션합니다.
     *
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        // TrafficLightContext 객체 생성
        TrafficLightContext trafficLight = new TrafficLightContext();

        // 상태 변경을 여러 번 반복하여 신호등 동작 시뮬레이션
        for (int i = 0; i < 5; i++) {
            trafficLight.change();
        }
    }
}
