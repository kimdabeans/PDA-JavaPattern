// 신호등 컨텍스트 클래스
public class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext() {
        // 초기 상태를 빨간 불로 설정
        state = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        // 상태 변경 메소드
        state.handle(this);
    }
}