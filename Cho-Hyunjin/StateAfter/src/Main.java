public class Main {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        // 상태 변경을 여러 번 반복하여 신호등 동작 시뮬레이션
        for (int i = 0; i < 5; i++) {
            trafficLight.change();
        }
    }
}





