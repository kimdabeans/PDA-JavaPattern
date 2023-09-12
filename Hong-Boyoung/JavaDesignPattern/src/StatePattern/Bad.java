package StatePattern;
/**
 * Bad 클래스는 나쁜 감정 상태를 나타내는 클래스입니다.
 * Emotion 클래스를 상속받아 구현되었으며, 다양한 상태 변화와 감정을 표현합니다.
 */
public class Bad extends Emotion {
    /**
     * {@inheritDoc}
     * 새로 산 스마트폰으로 게임을 많이 할 수 있어서 한 단계 기분이 좋아집니다.
     *
     * @return 게임을 많이 할 수 있어 행복한 상태인 Perfect 객체
     */
    @Override
    public State playGameAlot() {
        return new SoSo();
    }
    /**
     * {@inheritDoc}
     * 스마트폰이 잠겨서 한 단계 기분이 나빠집니다.
     *
     * @return 스마트폰이 잠긴 후 기분이 그럭저럭인 SoSo 객체
     */
    @Override
    public State lockSmartphone() {
        return new Terrible();
    }
    /**
     * {@inheritDoc}
     * 현재의 감정 상태를 콘솔에 출력합니다.
     */
    @Override
    public void printCurrentEmotion() {
        System.out.println("별로입니다.");
    }
}
