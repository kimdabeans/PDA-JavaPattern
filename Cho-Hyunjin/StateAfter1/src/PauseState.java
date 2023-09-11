// PauseState 클래스 정의
public class PauseState implements GameState {
    @Override
    public void start(GameContext context) {
        System.out.println("게임 재개됨. 현재 일시정지 상태 해제.");
        context.setState(new PlayingState());
        context.resumeGame();
    }

    @Override
    public void pause(GameContext context) {
        System.out.println("게임 이미 일시정지 상태.");
    }

    @Override
    public void resume(GameContext context) {
        System.out.println("게임 재개됨. 현재 일시정지 상태 해제.");
        context.setState(new PlayingState());
        context.resumeGame();
    }

    @Override
    public void gameOver(GameContext context) {
        System.out.println("게임 종료됨.");
        context.setState(new GameOverState());
        context.gameOver();
    }

    @Override
    public String getDescription() {
        return "일시정지 상태";
    }
}