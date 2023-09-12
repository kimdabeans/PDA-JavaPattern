package Bridge;

/**
 * CountDisplay 클래스는 Display 클래스를 확장하여 여러 번 표시하는 기능을 제공합니다.
 */
public class CountDisplay extends Display {

    /**
     * CountDisplay 객체를 생성합니다.
     * @param impl DisplayImpl 추상 클래스
     */
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    /**
     * 주어진 횟수만큼 문자열을 반복합니다.
     * @param times 문자열 출력을 반복할 횟수
     */
    public void multiDisplay(int times) {
        System.out.println("=====multiDisplay=====");
        open();
        for(int i=0; i<times; i++) {
            print();
        }
        close();
    }
}
