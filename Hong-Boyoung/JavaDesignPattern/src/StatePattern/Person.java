package StatePattern;
/**
 * Person 클래스는 상태(State)를 가진 개인을 나타내는 클래스입니다.
 * 각 개인은 다양한 감정 상태를 가질 수 있으며, 감정 상태를 변경하고 현재 감정을 표시할 수 있습니다.
 */
public class Person {
    private State state;
    /**
     * Person 클래스의 생성자입니다.
     *
     * @param state 초기 감정 상태를 설정하는 State 객체
     */
    public Person(State state) {
        this.state = state;
    }
    /**
     * 스마트폰을 새로 산 상황을 모델링한 메서드입니다.
     * 상태를 변경하고 현재 감정을 표시합니다.
     */
    public void buyNewSmartphone() {
        state = state.buyNewSmartphone();
        state.printCurrentEmotion();
    }
    /**
     * 새로 산 스마트폰으로 게임을 많이 하는 상황을 모델링한 메서드입니다.
     * 상태를 변경하고 현재 감정을 표시합니다.
     */
    public void playGameAlot() {
        state = state.playGameAlot();
        state.printCurrentEmotion();
    }
    /**
     * 스마트폰이 타임락에 걸린 상황을 모델링한 메서드입니다.
     * 상태를 변경하고 현재 감정을 표시합니다.
     */
    public void lockSmartphone() {
        state = state.lockSmartphone();
        state.printCurrentEmotion();
    }
    /**
     * 현재의 감정 상태를 표시하는 메서드입니다.
     */
    public void printCurrentEmotion() {
        state.printCurrentEmotion();
    }
}
