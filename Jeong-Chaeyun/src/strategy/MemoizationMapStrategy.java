package strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 맵을 사용한 메모이제이션을 활용하여 피보나치 수열을 계산하는 계산 전략 클래스입니다.
 * 이 클래스는 {@link Strategy} 인터페이스를 구현하며, 맵을 활용하여 중복 계산을 피하고 피보나치 수열을 빠르게 계산합니다.
 *
 *  @see Strategy
 */
public class MemoizationMapStrategy implements Strategy {

	private final Map<Integer, Long> map;

	/**
	 * MemoizationMapStrategy 클래스의 생성자입니다.
	 * 이 생성자는 피보나치 수열 계산을 위한 맵을 초기화합니다.
	 */
	public MemoizationMapStrategy(int n) {
		map = new HashMap<>();
		long result = 0;
	}

	/**
	 * 주어진 순서에 해당하는 피보나치 수열의 값을 계산합니다.
	 * 이 계산은 메모이제이션 맵을 활용하여 중복 계산을 피하고, 이미 계산된 결과를 가져와 사용합니다.
	 *
	 * @param n 계산할 피보나치 수열의 항 순서를 나타냅니다.
	 * @return 주어진 순서에 해당하는 피보나치 수열의 값
	 */
	@Override
	public long fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1) {
			map.put(n, 1L);
			return 1L;
		}
		if (!map.containsKey(n))
			map.put(n, fibonacci(n - 1) + fibonacci(n - 2));
		return map.get(n);
	}
}
