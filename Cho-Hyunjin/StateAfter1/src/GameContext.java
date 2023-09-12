// 게임 컨텍스트 인터페이스 정의
public interface GameContext {
    void setState(GameState state);
    void startGame();
    void pauseGame();
    void resumeGame();
    void gameOver();
}