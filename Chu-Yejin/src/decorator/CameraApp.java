package decorator;

/**
 * 스마트폰에 카메라 앱을 추가할 수 있는 클래스입니다.
 */
public class CameraApp extends AppDecorator {
    private Smartphone smartphone;

    /**
     * 카메라 앱의 생성자입니다.
     *
     * @param smartphone 스마트폰 객체
     */
    public CameraApp(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    /**
     * 스마트폰의 설명에 카메라 앱을 추가한 문자열을 반환하는 메서드입니다.
     *
     * @return 스마트폰 설명에 카메라 앱이 추가된 문자열
     */
    public String getDescription() {
        return smartphone.getDescription() + ", Camera App";
    }

    /**
     * 스마트폰 가격에 카메라 앱의 가격을 추가한 총 가격을 반환하는 메서드입니다.
     *
     * @return 스마트폰 가격에 카메라 앱 가격을 추가한 총 가격
     */
    public double cost() {
        return smartphone.cost() + 50.0;
    }
}