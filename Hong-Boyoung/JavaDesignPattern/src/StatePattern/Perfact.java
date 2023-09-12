package StatePattern;
/**
 * Perfact 클래스는 기쁨의 최상위 감정 상태를 나타내는 클래스입니다.
 * Emotion 클래스를 상속받아 구현되었으며, 다양한 상태 변화를 모델링합니다.
 */
public class Perfact extends Emotion{
    /**
     * {@inheritDoc}
     * 기분이 변경되지 않습니다.
     *
     * @return 기분이 그대로 유지되는 Perfect 객체
     */
    @Override // 기분이 이미 최상이기 때문에 변경되지 않음
    public State playGameAlot() {
        return this;
    }
    /**
     * {@inheritDoc}
     * 스마트폰에 타임락이 걸려서 한 단계 기분이 나빠집니다.
     *
     * @return 스마트폰이 잠기고 기분이 더 나쁜 Happy 객체
     */
    @Override
    public State lockSmartphone() {
        return new Happy();
    }
    /**
     * {@inheritDoc}
     * 현재의 감정 상태를 콘솔에 출력합니다.
     */
    @Override
    public void printCurrentEmotion() {
        System.out.println("최고입니다.");
    }
}
