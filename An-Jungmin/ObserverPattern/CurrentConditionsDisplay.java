package ObserverPattern;

/**
 * 현재 조건을 디스플레이하는 클래스입니다.
 * Observer 및 DisplayElement 인터페이스를 구현합니다.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float exitVelocity; // 타구 출구 속도
    private String pitch; // 투구 구종
    private String count; // 볼 카운트
    private HomerunData homerunData;
    /**
     * 주어진 데이터로 현재 조건 디스플레이 객체를 생성합니다.
     *
     * @param exitVelocity 타구 출구 속도
     * @param pitch        투구 구종
     * @param count        볼 카운트
     */
    public CurrentConditionsDisplay(HomerunData homerunData) {
        this.homerunData = homerunData;
    }

    /**
     * Observer 인터페이스의 update 메서드를 구현합니다.
     * 홈런 데이터를 업데이트하고, 디스플레이를 갱신합니다.
     *
     * @param exitVelocity 타구 출구 속도
     * @param pitch        투구 구종
     * @param count        볼 카운트
     */
    @Override
    public void update() {
        this.exitVelocity = homerunData.getVelocity();
        this.pitch = homerunData.getPitch();
        this.count = homerunData.getCount();

        display();
    }

    /**
     * DisplayElement 인터페이스의 display 메서드를 구현합니다.
     * 현재 조건을 출력합니다.
     */
    @Override
    public void display() {
        System.out.println("홈런 분석표: 타구 속도: " + exitVelocity + ", 구종: " + pitch + ", 볼 카운트: " + count);
    }


}