package StateAndSingleton;

public class CloseTime implements Time{
    private static CloseTime singleton = new CloseTime();

    private CloseTime(){

    }
    public static Time getInstance(){
        return singleton;
    }
    @Override
    public void doAlarm(Context context) {
        context.callTransactionAlarm("현재는 주식 거래 시간이 아닙니다!\n");
    }
}
