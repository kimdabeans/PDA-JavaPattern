package decorator;

/**
 * 이 클래스는 스마트폰에 음악 앱을 추가할 수 있습니다.
 */
public class MusicApp extends AppDecorator {
    private Smartphone smartphone;

    /**
     * 음악 앱의 생성자입니다.
     *
     * @param smartphone 스마트폰 객체
     */
    public MusicApp(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    /**
     * 스마트폰의 설명에 음악 앱을 추가한 문자열을 반환하는 메서드입니다.
     *
     * @return 스마트폰 설명에 음악 앱이 추가된 문자열
     */
    public String getDescription() {
        return smartphone.getDescription() + ", Music App";
    }

    /**
     * 스마트폰 가격에 음악 앱의 가격을 추가한 총 가격을 반환하는 메서드입니다.
     *
     * @return 스마트폰 가격에 음악 앱 가격을 추가한 총 가격
     */
    public double cost() {
        return smartphone.cost() + 30.0;
    }
}