// Bird 클래스 정의
class Bird {
    private BirdState currentState;

    public Bird() {
        currentState = new RestingState(); // 초기 상태를 휴식 중으로 설정
    }

    public void changeState(BirdState newState) {
        currentState = newState;
    }

    public void performAction() {
        currentState.performAction(this);
    }

    public void eatFood() {
        currentState.eatFood(this);
    }

    public String getCurrentStateDescription() {
        return currentState.getDescription();
    }
}