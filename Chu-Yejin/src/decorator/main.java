package decorator;

/**
 * 스마트폰에 앱을 추가하고 구매 정보를 출력하는 메인 클래스입니다.
 */
public class main {
    public static void main(String[] args) {
        // 기본 스마트폰 생성
        Smartphone smartphone = new BasicSmartphone();

        // 카메라 앱 추가
        smartphone = new CameraApp(smartphone);

        // 음악 앱 추가
        smartphone = new MusicApp(smartphone);

        // 최종 스마트폰 구매 정보 출력
        System.out.println("Smartphone: " + smartphone.getDescription());
        System.out.println("최종 금액: $" + smartphone.cost());
    }
}