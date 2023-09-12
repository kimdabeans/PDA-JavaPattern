package strategy;

import java.util.Scanner;

/** 사용자는 프로그램을 실행하면 값을 입력하고,
 * 기본 계산 전략 {@link BasicStrategy},
 * 메모이제이션 배열 기반 전략 {@link MemoizationArrayStrategy},
 * 메모이제이션 맵 기반 전략 {@link MemoizationMapStrategy} 중에서 선택할 수 있습니다.
 * 선택한 전략에 따라 피보나치 수열을 계산하고 실행 시간을 출력합니다.
 *
 * @see Strategy
 * @see BasicStrategy
 * @see MemoizationArrayStrategy
 * @see MemoizationMapStrategy
 */
public class Main {

	/**
	 * 프로그램의 진입점입니다.
	 * 사용자로부터 값을 입력받아 피보나치 수열을 계산하고 실행 시간을 출력합니다.
	 *
	 * @param args 커맨드 라인 인자 (사용하지 않음)
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int n = sc.nextInt();

		Strategy strategy1 = new BasicStrategy(n);
		CheckTime.checkTime(n, strategy1);

		Strategy strategy2 = new MemoizationArrayStrategy(n);
		CheckTime.checkTime(n, strategy2);

		Strategy strategy3 = new MemoizationMapStrategy(n);
		CheckTime.checkTime(n, strategy3);
	}
}
