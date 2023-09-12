package ObserverPattern;

/**
 * 주제(Subject) 역할을 하는 인터페이스입니다.
 * 옵저버들을 등록, 제거하고 업데이트를 통지하는 메서드를 정의합니다.
 */
public interface Subject {
    /**
     * 옵저버를 등록합니다.
     *
     * @param o 등록할 옵저버 객체
     */
    public void registerObserver(Observer o);

    /**
     * 옵저버를 제거합니다.
     *
     * @param o 제거할 옵저버 객체
     */
    public void removeObserver(Observer o);

    /**
     * 등록된 옵저버들에게 업데이트를 통지합니다.
     */
    public void notifyObserver();
}