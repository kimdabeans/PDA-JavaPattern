package StateAndSingleton;

import static StateAndSingleton.Utility.balance;

/**
 * WarningState 클래스입니다.
 * State 인터페이스를 구현했으며, 주식 거래 경고 상태를 처리하는 클래스입니다.
 */
public class WarningState implements State{
    /** 싱글톤 인스턴스 */
    private static WarningState singleton = new WarningState();

    /**
     * WarningState 클래스의 생성자입니다.
     * (singleton 패턴 사용을 위한 private로 선언)
     */
    private WarningState(){
    }
    /**
     * WarningState의 싱글톤 인스턴스를 반환합니다.
     *
     * @return WarningState 싱글톤 인스턴스
     */
    public static State getInstance(){
        return singleton;
    }

    /**
     * 현재 주식 거래자의 잔고를 기반으로 매수를 처리하는 메서드입니다.
     * 잔고가 0 미만이라면 매수가 금지되고, 신용 등급이 경고 상태임을 알립니다.
     *
     * @param context 거래 상태에 관련된 컨텍스트 객체
     * @return 매수 후의 잔고
     */
    @Override
    public int buy(Context context) {
        if(balance - context.getStock() < 0){
            context.callTransactionAlarm("현재 고객님은 잔고 부족입니다! 매수가 금지됩니다.");
            return 0;
        }
        context.callTransactionAlarm("현재 고객님은 주식 거래 경고 단계입니다! 조심하세요!");
        return balance - context.getStock();
    }
    /**
     * 현재 주식 거래자의 잔고를 기반으로 매도를 처리하는 메서드입니다.
     * 신용 등급이 경고 상태임을 알립니다.
     *
     * @param context 거래 상태에 관련된 컨텍스트 객체
     * @return 매도 후의 잔고
     */
    @Override
    public int sell(Context context) {
        context.callTransactionAlarm("현재 고객님은 주식 거래 경고 단계 입니다! 매도는 가능합니다.");
        return balance + context.getStock();
    }
}
