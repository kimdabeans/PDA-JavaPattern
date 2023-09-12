package AfterState;

/**
 * 메인 클래스에서는 SafeFrame을 생성하고 시간을 업데이트합니다.
 * @author heebin
 */
public class main {

    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("Safe Frame Example");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour); // 시간 설정
                try {
                    Thread.sleep(1000); // 1초마다 시간 업데이트
                    
                } catch (InterruptedException e) {
                    // 예외 처리
                }
            }
        }
    }
}