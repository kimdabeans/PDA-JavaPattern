package strategy;

/**
 * 배열을 사용한 메모이제이션을 활용하여 피보나치 수열을 계산하는 계산 전략 클래스입니다.
 * 이 클래스는 {@link Strategy} 인터페이스를 구현하며, 배열을 활용하여 중복 계산을 피하고 피보나치 수열을 빠르게 계산합니다.
 *
 *  @see Strategy
 */
public class MemoizationArrayStrategy implements Strategy {

	private static long[] array;

	/**
	 * MemoizationArrayStrategy 클래스의 생성자입니다.
	 * 이 생성자는 피보나치 수열 계산을 위한 배열을 초기화합니다.
	 * 배열의 크기는 입력 값 n에 1을 더한 크기로 설정됩니다.
	 *
	 * @param n 계산에 사용되는 입력 값으로, 피보나치 수열의 항 순서를 나타냅니다.
	 */
	public MemoizationArrayStrategy(int n) {
		array = new long[n + 1];
	}

	/**
	 * 주어진 순서에 해당하는 피보나치 수열의 값을 계산합니다.
	 * 이 계산은 메모이제이션 배열을 활용하여 중복 계산을 피하고, 이미 계산된 결과를 가져와 사용합니다.
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
		if (array[n] == 0)
			array[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return array[n];
	}
}
