package strategy_pattern.example2.before;

/**
 * Main 클래스는 프로그램의 진입점을 제공합니다.
 * Gildong과 Minsu 객체를 생성하고, 각각의 거래 전략을 실행하는 예제를 포함합니다.
 */
public class Main {
    public static void main(String[] args) {
        // Chulsu 객체 생성
        Gildong chulsu = new Gildong();
        System.out.println("Gildong's trading strategies:");
        chulsu.buy();
        chulsu.sell();

        // Minsu 객체 생성
        Minsu minsu = new Minsu();
        System.out.println("\nMinsu's trading strategies:");
        minsu.buy();
        minsu.sell();
    }
}
