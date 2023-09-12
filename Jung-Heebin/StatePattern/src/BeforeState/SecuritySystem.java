package BeforeState;

/**
 * SecuritySystem 클래스는 시간대에 따라 다르게 동작하는 보안 시스템을 나타냅니다.
 * 주간인 경우 금고를 사용하고, 야간인 경우 비상 상황을 경비 센터에 통보합니다.
 */
public class SecuritySystem {

    private boolean isDayTime; // 주간 여부를 나타내는 변수

    /**
     * 시간을 설정합니다.
     *
     * @param hour 시간 (0-23)
     */
    public void setClock(int hour) {
        isDayTime = (hour >= 9 && hour <= 17); // 9시부터 17시까지를 주간으로 설정
    }

    /**
     * 주간인 경우 금고를 사용하고, 야간인 경우 비상 상황을 경비 센터에 통보합니다.
     */
    public void useSafe() {
        if (isDayTime) {
            recordLog("use safe");
        } else {
            callSecurityCenter("emergency!!!");
        }
    }

    /**
     * 경비 센터에 호출을 보냅니다.
     *
     * @param message 호출 메시지
     */
    private void callSecurityCenter(String message) {
        System.out.println("call! : " + message);
    }

    /**
     * 경비 센터에 기록을 남깁니다.
     *
     * @param message 기록 메시지
     */
    private void recordLog(String message) {
        System.out.println("recordLog : " + message);
    }

    public static void main(String[] args) {
        SecuritySystem securitySystem = new SecuritySystem();
        int[] hours = {8, 13, 20};
        for (int hour : hours) {
            securitySystem.setClock(hour);
            securitySystem.useSafe();
        }
    }
}
