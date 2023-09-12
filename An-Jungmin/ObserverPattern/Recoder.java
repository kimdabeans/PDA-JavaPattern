package ObserverPattern;
/**
 * 홈런 데이터를 관찰하고 현재 상태 디스플레이를 테스트하는 클래스입니다.
 */
public class Recoder {
    public static void main(String[] args) {
        // 홈런 데이터 객체 생성
        HomerunData homerunData = new HomerunData();

        // 현재 상태 디스플레이 객체 생성
        Observer currentConditionsDisplay = new CurrentConditionsDisplay(homerunData);

        // 현재 상태 디스플레이를 홈런 데이터의 옵저버로 등록
        homerunData.registerObserver(currentConditionsDisplay);

        // 홈런 데이터 업데이트
        homerunData.setHomerunData(160, "curve", "1B2S");



        homerunData.setHomerunData(160, "curve", "2B2S");

        // 현재 상태 디스플레이를 제거
        System.out.println("현재 상태 디스플레이를 제거합니다.");
        homerunData.notifyObserver();
    }
}