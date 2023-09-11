package StateAndSingleton;

public class OpenTime implements Time{
    private static OpenTime singleton = new OpenTime();

    private OpenTime(){

    }
    public static Time getInstance(){
        return singleton;
    }
    @Override
    public void doAlarm(Context context) {
        context.callTransactionAlarm("현재는 주식 거래 시간입니다.\n");
    }
}
