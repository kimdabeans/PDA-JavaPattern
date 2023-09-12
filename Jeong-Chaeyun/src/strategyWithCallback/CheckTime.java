package strategyWithCallback;

import java.time.Duration;
import java.time.Instant;

public class CheckTime {

	public static void checkTime(int n, Strategy strategy) {

		Instant beforeTime = Instant.now();
		long result = strategy.fibonacci(n);
		Instant afterTime = Instant.now();
		long diffTime = Duration.between(beforeTime, afterTime).toMillis();

		String name = strategy.getClass().getName();
		print(name, n, result, diffTime);
	}

	private static void print(String name, int n, long result, long diffTime) {
		System.out.println("======================================");
		System.out.println(name + "의 결과: " + result);
		System.out.println(name + "의 실행 시간(ms): " + diffTime);
	}
}
