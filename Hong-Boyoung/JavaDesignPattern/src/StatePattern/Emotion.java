package StatePattern;
/**
 * Emotion 클래스는 상태(State)를 나타내는 State 인터페이스를 구현하는 추상 클래스입니다.
 * 이 클래스를 상속받아 다양한 감정 상태를 구현할 수 있습니다.
 */
public abstract class Emotion implements State {
    /**
     * {@inheritDoc}
     * 스마트폰을 새로 사면 기분이 최상이 됩니다.
     *
     * @return 스마트폰을 새로 산 상태를 나타내는 State 객체
     */
    @Override
    public State buyNewSmartphone() {
        return new Perfact();
    }
    /**
     * {@inheritDoc}
     * 스마트폰을 잃어버리면 기분이 최악이 됩니다.
     *
     * @return 스마트폰을 잃어버린 상태를 나타내는 State 객체
     */
    @Override
    public State loseSmartphone() {
        return new Terrible();
    }
}