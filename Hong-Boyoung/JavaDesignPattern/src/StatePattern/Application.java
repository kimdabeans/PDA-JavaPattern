package StatePattern;
/**
 * Application 클래스는 감정 상태를 시뮬레이션하는 예제 애플리케이션입니다.
 * Person 객체를 생성하고 감정 상태를 변경하며 현재 감정을 출력합니다.
 */
public class Application {
    public static void main(String[] args) {
        // 초기 상태로 'SoSo' 상태를 설정한 Person 객체를 생성합니다.
        Person person = new Person(new SoSo());
        // 현재 감정 상태를 출력합니다. (SoSo한 감정 상태)
        person.printCurrentEmotion();
        // SoSo한 상태에서 핸드폰으로 게임을 많이 하여 'Happy' 상태로 변경하고 SoSo한 감정을 출력합니다.
        person.playGameAlot();
        // Happy한 상태에서 새로운 스마트폰을 사서 'Perfect' 상태로 변경하고 Happy한 감정을 출력합니다.
        person.buyNewSmartphone();
        // Perfact한 상태에서 스마트폰에 타임락이 걸려 'Bad' 상태로 변경하고 Perfact한 감정을 출력합니다.
        person.lockSmartphone();
        // Bad한 상태에서 스마트폰 타임락 시간이 길어져서 'SoSo' 상태로 유지하며 SoSo한 감정을 출력합니다.
        person.lockSmartphone();
        // Bad한 상태에서 스마트폰 타임락 시간이 더욱 길어져서 'Terrible' 상태로 변경하고 Bad한 감정을 출력합니다.
        person.lockSmartphone();
        // Terrible한 상태에서 Terrible한 감정을 출력합니다.
        person.lockSmartphone();
    }
}