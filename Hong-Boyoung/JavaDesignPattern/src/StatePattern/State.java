package StatePattern;
/**
 * State 인터페이스는 상태(State) 관련 작업을 정의하는 메서드를 포함합니다.
 * 각 메서드는 상태 변경 또는 감정을 나타내며, 해당 상태를 나타내는 객체를 반환합니다.
 */
public interface State {
    /**
     * 새로운 스마트폰을 사게 된 상황을 모델링한 메서드입니다.
     */
    State buyNewSmartphone();
    /**
     * 새로 산 핸드폰으로 게임을 많이 할 수 있는 상황을 모델링한 메서드입니다.
     *
     * @return 새로 산 스마트폰으로 게임을 많이 하는 상태를 나타내는  State 객체
     */
    State playGameAlot();
    /**
     * 스마트폰으로 게임을 너무 많이 해서 타임락에 걸린 상황을 모델링한 메서드입니다.
     *
     * @return 게임을 너무 많이 해서 타임락에 걸린 상태를 나타내는 State 객체
     */
    State lockSmartphone();
    /**
     * 새로산 스마트폰을 잃어버리는 상황을 모델링한 메서드입니다.
     */
    State loseSmartphone();
    /**
     * 현재의 감정 또는 상태를 출력하는 메서드입니다.
     * 구현에 따라 이 메서드는 화면에 감정을 표시할 수 있습니다.
     */
    void printCurrentEmotion();
}
