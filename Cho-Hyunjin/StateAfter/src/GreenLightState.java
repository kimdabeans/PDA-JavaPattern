/**
 * 초록 불 상태 클래스입니다. 이 클래스는 {@link TrafficLightState} 인터페이스를 구현합니다.
 * 초록 불 상태에서는 신호등이 "진행" 신호를 나타내며, 어떤 동작을 수행하고 일정 시간이 지난 후 다음 상태로 전환될 수 있습니다.
 */
public class GreenLightState implements TrafficLightState {
    /**
     * 현재 상태에서의 동작을 처리합니다. 이 메소드는 "초록 불 - 진행" 메시지를 출력하고,
     * 일정 시간이 지난 후 다음 상태로 전환되도록 {@link TrafficLightContext}에게 요청합니다.
     *
     * @param context 현재 상태를 관리하는 {@link TrafficLightContext} 객체
     */
    @Override
    public void handle(TrafficLightContext context) {
        System.out.println("초록 불 - 진행");
        // 초록 불 상태에서의 동작을 수행
        // 예를 들어, 일정 시간 기다린 후 다음 상태로 전환할 수 있음
        context.setState(new YellowLightState());
    }
}