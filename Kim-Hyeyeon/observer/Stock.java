package observer;
/**
 * 주식 정보와 관련된 인터페이스.
 */
public interface Stock {
	void updatePrice(double newPrice);
	double getPrice();
}
