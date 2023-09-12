package strategy;

import java.util.Scanner;

public class Main {

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
