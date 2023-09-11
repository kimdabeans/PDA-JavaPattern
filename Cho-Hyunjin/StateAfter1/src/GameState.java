// 게임 상태 인터페이스 정의
public interface GameState {
    void start(GameContext context);
    void pause(GameContext context);
    void resume(GameContext context);
    void gameOver(GameContext context);
    String getDescription();
}