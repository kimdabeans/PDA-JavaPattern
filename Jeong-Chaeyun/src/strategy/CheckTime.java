package strategy;

import java.time.Duration;
import java.time.Instant;

/** 이 클래스는 주어진 계산 전략을 받아와 피보나치 수열을 계산하고, 결과와 실행 시간을 출력하는 기능을 제공합니다.
 *
 * @see Strategy
 * @see java.time.Duration
 * @see java.time.Instant
 */
public class CheckTime {

	/**
	 * 주어진 계산 전략에 따라 피보나치 수열을 계산하고 실행 시간을 측정하여 출력합니다.
	 *
	 * @param n        계산할 피보나치 수열의 항 순서를 나타내는 정수입니다.
	 * @param strategy 계산에 사용할 전략을 나타내는 {@link Strategy} 인터페이스 구현체입니다.
	 */
	public static void checkTime(int n, Strategy strategy) {

		Instant beforeTime = Instant.now();
		long result = strategy.fibonacci(n);
		Instant afterTime = Instant.now();
		long diffTime = Duration.between(beforeTime, afterTime).toMillis();

		String name = strategy.getClass().getName();
		print(name, n, result, diffTime);
	}

	/**
	 * 결과와 실행 시간을 출력합니다.
	 *
	 * @param name     실행 전략의 클래스 이름입니다.
	 * @param n        계산된 피보나치 수열의 항 순서를 나타내는 정수입니다.
	 * @param result   계산된 피보나치 수열의 값입니다.
	 * @param diffTime 실행 시간 (밀리초)입니다.
	 */
	private static void print(String name, int n, long result, long diffTime) {
		System.out.println("======================================");
		System.out.println(name + "의 결과: " + result);
		System.out.println(name + "의 실행 시간(ms): " + diffTime);
	}
}
