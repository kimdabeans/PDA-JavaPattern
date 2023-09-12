package BeforeState;

/**
 * main 클래스는 SecuritySystem 클래스를 사용하여 각 시간대에 따른 시뮬레이션을 실행합니다.
 */
public class main {

    public static void main(String[] args) {
        SecuritySystem securitySystem = new SecuritySystem();
        
        // 각 시간대에 대한 시뮬레이션 실행
        // 8시: 야간, 긴급 상황 통보
        securitySystem.setClock(8);
        securitySystem.useSafe();

        // 13시: 주간, 금고 사용 기록
        securitySystem.setClock(13);
        securitySystem.useSafe();

        // 20시: 야간, 긴급 상황 통보
        securitySystem.setClock(20);
        securitySystem.useSafe();
    }
}
