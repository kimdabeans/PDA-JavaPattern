package StatePattern;
/**
 * Terrible 클래스는 최악의 감정 상태를 나타내는 클래스입니다.
 * Emotion 클래스를 상속받아 구현되었으며, 다양한 상태 변화와 감정을 표현합니다.
 */
public class Terrible extends Emotion {
    /**
     * {@inheritDoc}
     * 새로 산 스마트폰으로 게임을 많이 할 수 있어서 한 단계 기분이 좋아집니다.
     *
     * @return 게임을 많이 할 수 있어 행복한 상태인 Perfect 객체
     */
    @Override
    public State playGameAlot() {
        return new Bad();
    }
    /**
     * {@inheritDoc}
     * 기분이 변경되지 않습니다.
     * 기분이 이미 최악이기 때문에 변경되지 않음
     *
     * @return 현재의 최악 상태를 나타내는 Terrible 객체
     */
    @Override
    public State lockSmartphone() {
        return this;
    }
    /**
     * {@inheritDoc}
     * 현재의 감정 상태를 콘솔에 출력합니다.
     */
    @Override
    public void printCurrentEmotion() {
        System.out.println("최악입니다.");
    }
}
