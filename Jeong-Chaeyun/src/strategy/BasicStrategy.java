package strategy;

/**
 * 기본적인 피보나치 수열 계산 전략을 구현한 클래스입니다.
 * 이 클래스는 {@link Strategy} 인터페이스를 구현합니다.
 *
 * @author Jeong Chaeyun
 * @see Strategy
 */
public class BasicStrategy implements Strategy {

	/**
	 * BasicStrategy 클래스의 생성자입니다.
	 *
	 * @param n 계산에 사용되는 인자입니다.
	 */
	public BasicStrategy(int n) {
		long result = 0;
	}

	/**
	 * 주어진 순서에 해당하는 피보나치 수열의 값을 계산합니다.
	 *
	 * @param n 계산할 피보나치 수열의 항 순서를 나타냅니다.
	 * @return 주어진 순서에 해당하는 피보나치 수열의 값
	 */
	@Override
	public long fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
