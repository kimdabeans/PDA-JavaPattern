// 초록 불 상태 클래스
public class GreenLightState implements TrafficLightState {
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("초록 불 - 진행");
        // 초록 불 상태에서의 동작을 수행
        // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
        context.setState(new YellowLightState());
    }
}