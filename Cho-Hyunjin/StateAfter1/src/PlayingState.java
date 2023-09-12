// PlayingState 클래스 정의
public class PlayingState implements GameState {
    @Override
    public void start(GameContext context) {
        System.out.println("게임 시작됨. 현재 플레이 중 상태.");
        context.setState(this);
        context.startGame();
    }

    @Override
    public void pause(GameContext context) {
        System.out.println("게임 일시정지됨.");
        context.setState(new PauseState());
        context.pauseGame();
    }

    @Override
    public void resume(GameContext context) {
        // 플레이 중 상태에서는 재개 동작을 지원하지 않음.
        System.out.println("플레이 중 상태입니다. 재개할 수 없음.");
    }

    @Override
    public void gameOver(GameContext context) {
        System.out.println("게임 종료됨.");
        context.setState(new GameOverState());
        context.gameOver();
    }

    @Override
    public String getDescription() {
        return "플레이 중 상태";
    }
}