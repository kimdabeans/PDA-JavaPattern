class RestingState implements BirdState {
    @Override
    public void performAction(Bird bird) {
        bird.changeState(this);
    }

    @Override
    public void eatFood(Bird bird) {
        bird.changeState(new RestingState());
    }

    @Override
    public String getDescription() {
        return "새가 휴식 중입니다.";
    }
}


