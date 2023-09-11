package StateAndSingleton;

public interface Context {
	public abstract void setInfo(int hour, TimeType timeType, StateType stateType, int stock);
	public abstract int getStock();
	public abstract void callTransactionAlarm(String msg);
	public abstract void setTimeType(TimeType timeType);
}
