package strategy;

import java.util.HashMap;
import java.util.Map;

public class MemoizationMapStrategy implements Strategy {

	private final Map<Integer, Long> map;

	public MemoizationMapStrategy(int n) {
		map = new HashMap<>();
		long result = 0;
	}

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
