package strategy;

public class MemoizationArrayStrategy implements Strategy {

	private static long[] array;

	public MemoizationArrayStrategy(int n) {
		array = new long[n + 1];
	}

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
