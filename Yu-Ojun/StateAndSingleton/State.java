package StateAndSingleton;

/** State 인터페이스입니다.
 * 고객 계좌 잔액 상태에 따른 신용도 유형에 따라 구현하고자 하는 메서드를 정의합니다.
 *
 * @see Context
 */
public interface State {
	/**
	 * 주어진 Context 객체를 기반으로 구체적인 구매 동작을 수행합니다.
	 *
	 * @param context 구매 동작을 수행할 Context 객체
	 * @return 구매 동작의 결과를 나타내는 정수 값
	 */
	public abstract int buy(Context context);
	/**
	 * 주어진 Context 객체를 기반으로 구체적인 판매 동작을 수행합니다.
	 *
	 * @param context 판매 동작을 수행할 Context 객체
	 * @return 판매 동작의 결과를 나타내는 정수 값
	 */
	public abstract int sell(Context context);
}
