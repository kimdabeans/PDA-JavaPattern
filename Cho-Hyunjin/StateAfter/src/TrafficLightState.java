// 상태 패턴에서 사용할 상태 인터페이스
public interface TrafficLightState {
    void handle(TrafficLightContext context);
}