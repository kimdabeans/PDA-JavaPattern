/**
 * 신호등 상태를 나타내는 인터페이스입니다.
 */
public interface TrafficLightState {
    /**
     * 현재 상태에서의 동작을 처리합니다.
     * @param context 동작을 수행하는 신호등 컨텍스트
     */
    void handle(TrafficLightContext context);
}