
package ObserverPattern;

/**
 * 주제(Subject)에서 발생한 변경 사항을 관찰하고 업데이트하는 인터페이스입니다.
 */
public interface Observer {
    /**
     * 주제(Subject)에서 변경 사항이 발생했을 때 호출되는 메서드입니다.
     *
     * @param exitVelocity 타구 출구 속도
     * @param pitch        투구 구종
     * @param count        볼 카운트
     */
    void update();
}