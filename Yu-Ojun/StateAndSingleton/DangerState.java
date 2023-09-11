package StateAndSingleton;

public class DangerState implements State{
    private static DangerState singleton = new DangerState();

    private DangerState(){

    }

    public static State getInstance(){
        return singleton;
    }

    @Override
    public int buy(Context context) {
        if(Main.balance - context.getStock() < 0){
            context.callTransactionAlarm("현재 고객님은 잔고 부족입니다! 매수가 금지됩니다.");
            return 0;
        }
        context.callTransactionAlarm("현재 고객님은 주식 거래 위험 단계입니다! 매수가 금지됩니다.");
        return Main.balance - context.getStock();
    }

    @Override
    public int sell(Context context) {
        context.callTransactionAlarm("현재 고객님은 주식 거래 위험단계 입니다! 매도는 가능합니다.");
        return Main.balance + context.getStock();
    }
}
