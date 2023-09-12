// GameOverState 클래스 정의
public class GameOverState implements GameState {
    @Override
    public void start(GameContext context) {
        System.out.println("게임 재시작됨.");
        context.setState(new PlayingState());
        context.startGame();
    }

    @Override
    public void pause(GameContext context) {
        System.out.println("게임 이미 종료됨.");
    }

    @Override
    public void resume(GameContext context) {
        System.out.println("게임 이미 종료됨.");
    }

    @Override
    public void gameOver(GameContext context) {
        System.out.println("게임 이미 종료됨.");
    }

    @Override
    public String getDescription() {
        return "게임 종료 상태";
    }
}