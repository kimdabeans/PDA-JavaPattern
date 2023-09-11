// BirdState 인터페이스 정의
public interface BirdState {
    void performAction(Bird bird);
    void eatFood(Bird bird);
    String getDescription();
}