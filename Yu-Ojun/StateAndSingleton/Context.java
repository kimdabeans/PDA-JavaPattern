package StateAndSingleton;

/** Context 인터페이스입니다.
 *  SafeFrame 클래스에 구현하고자 하는 메서드를 정의합니다.
 */
public interface Context {
	/**
	 * Context 객체의 정보를 설정합니다.
	 *
	 * @param hour 현재 시간
	 * @param timeType 시간 유형
	 * @param stateType 상태 유형
	 * @param stock 주식 가격
	 */
	public abstract void setInfo(int hour, TimeType timeType, StateType stateType, int stock);
	/**
	 * 현재 주식 가격을 반환합니다.
	 *
	 * @return 현재 주식 가격
	 */
	public abstract int getStock();
	/**
	 * 거래에 대한 알림메시지를 보냅니다.
	 *
	 * @param msg 알림 메시지
	 */
	public abstract void callTransactionAlarm(String msg);
}
