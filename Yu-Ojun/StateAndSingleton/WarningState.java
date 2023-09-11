package StateAndSingleton;

public class WarningState implements State{
    private static WarningState singleton = new WarningState();

    private WarningState(){

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
        context.callTransactionAlarm("현재 고객님은 주식 거래 경고 단계입니다! 조심하세요!");
        return Main.balance - context.getStock();
    }

    @Override
    public int sell(Context context) {
        context.callTransactionAlarm("현재 고객님은 주식 거래 경고 단계 입니다! 매도는 가능합니다.");
        return Main.balance + context.getStock();
    }
}
