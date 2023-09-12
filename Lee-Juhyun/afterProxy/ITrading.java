package afterProxy;

/**
 * 주식 거래를 위한 인터페이스입니다.
 * 실제 주식 거래 로직을 구현하는 클래스들은 이 인터페이스를 구현해야 합니다.
 */
public interface ITrading {
	/**
	 * 주식 거래가 성공했을 때 호출되는 메서드입니다.
	 */
	public abstract void successfulStockTrading();
}
