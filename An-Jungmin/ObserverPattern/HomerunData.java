package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 홈런 데이터를 관리하고 옵저버들에게 업데이트를 통지하는 클래스입니다.
 * Subject 인터페이스를 구현합니다.
 */
public class HomerunData implements Subject {

    private float exitVelocity; // 타구 출구 속도
    private String pitch; // 투구 구종
    private String count; // 볼 카운트
    private List<Observer> observers; // 옵저버 목록

    /**
     * HomerunData 객체를 생성합니다.
     * 옵저버 목록을 초기화합니다.
     */
    public HomerunData() {
        observers = new ArrayList<Observer>();
    }

    /**
     * Observer 인터페이스의 registerObserver 메서드를 구현합니다.
     * 옵저버를 등록합니다.
     *
     * @param o 등록할 옵저버 객체
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Observer 인터페이스의 removeObserver 메서드를 구현합니다.
     * 옵저버를 제거합니다.
     *
     * @param o 제거할 옵저버 객체
     */
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Observer 인터페이스의 notifyObservers 메서드를 구현합니다.
     * 등록된 옵저버들에게 업데이트를 통지합니다.
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * 데이터가 변경될 때 옵저버들에게 업데이트를 통지합니다.
     */
    public void datasChanged() {
        notifyObserver();
    }

    /**
     * 홈런 데이터를 설정하고 데이터 변경을 통지합니다.
     *
     * @param exitVelocity 타구 출구 속도
     * @param pitch        투구 구종
     * @param count        볼 카운트
     */
    public void setHomerunData(float exitVelocity, String pitch, String count) {
        this.exitVelocity = exitVelocity;
        this.pitch = pitch;
        this.count = count;

        datasChanged();
    }

    /**
     * 타구 출구 속도를 반환합니다.
     *
     * @return 타구 출구 속도
     */
    public float getVelocity() {
        return this.exitVelocity;
    }

    /**
     * 투구 구종을 반환합니다.
     *
     * @return 투구 구종
     */
    public String getPitch() {
        return this.pitch;
    }

    /**
     * 볼 카운트를 반환합니다.
     *
     * @return 볼 카운트
     */
    public String getCount() {
        return this.count;
    }
}