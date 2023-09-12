/**
 * 신호등 컨텍스트 클래스입니다.
 */
public class TrafficLightContext {
    private TrafficLightState state;

    /**
     * TrafficLightContext 클래스의 생성자입니다. 초기 상태를 빨간 불로 설정합니다.
     */
    public TrafficLightContext() {
        state = new RedLightState();
    }

    /**
     * 현재 상태를 변경합니다.
     * @param state 새로운 상태
     */
    public void setState(TrafficLightState state) {
        this.state = state;
    }

    /**
     * 현재 상태에서의 동작을 처리합니다.
     */
    public void change() {
        // 상태 변경 메소드
        state.handle(this);
    }
}