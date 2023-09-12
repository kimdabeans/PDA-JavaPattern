package strategyWithCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int n = sc.nextInt();
		CheckTime.checkTime(n, new Strategy() {
			@Override
			public long fibonacci(int n) {
				if (n == 0)
					return 0;
				if (n == 1)
					return 1;
				return fibonacci(n - 1) + fibonacci(n - 2);
			}
		});

		CheckTime.checkTime(n, new Strategy() {
			private final long[] array = new long[n + 1];

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
		});

		CheckTime.checkTime(n, new Strategy() {
			final Map<Integer, Long> map = new HashMap<>();
			final long result = 0;

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
		});
	}
}
