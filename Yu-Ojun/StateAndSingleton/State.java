package StateAndSingleton;

public interface State {
	public abstract int buy(Context context);
	public abstract int sell(Context context);
}
