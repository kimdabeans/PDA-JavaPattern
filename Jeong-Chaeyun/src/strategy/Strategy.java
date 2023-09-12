package strategy;

/**
 * Strategy 인터페이스는 n번째 피보나치 수를 계산하는 메서드를 정의합니다.
 */
public interface Strategy {

	/**
	 * n번째 피보나치 수를 계산합니다.
	 *
	 * @param n 계산할 피보나치 수의 위치.
	 * @return n번째 피보나치 수.
	 */
	long fibonacci(int n);
}
