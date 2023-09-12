package statePattern;

/**
 * Main 클래스는 상태 패턴(State Pattern)을 활용하여 시간에 따라 동작이 변경되는 시계 애플리케이션을 구현합니다.
 * 이 애플리케이션은 시간대(hour)에 따라 다양한 상태(State)를 가지며, 시간이 흐를 때마다 상태가 변경됩니다.
 *
 * 애플리케이션의 동작 흐름:
 * 1. 시간대에 따른 상태를 매핑하는 HashMap을 생성합니다.
 * 2. SafeFrame 객체를 생성하여 시계 애플리케이션 창을 초기화합니다.
 * 3. 무한 루프를 통해 시간을 1초 간격으로 변경하면서 상태를 업데이트합니다.
 *
 * @author Cho hayoung
 */
public class Main {

    public static void main(String[] args) {
        // 1. 시간대에 따른 상태를 매핑하는 HashMap을 생성합니다.
        // 2. SafeFrame 객체를 생성하여 시계 애플리케이션 창을 초기화합니다.
        SafeFrame frame = new SafeFrame("State Sample");

        // 3. 무한 루프를 통해 시간을 1초 간격으로 변경하면서 상태를 업데이트합니다.
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
