package strategy_pattern.example2.after;

// Main 클래스
public class Main {
    public static void main(String[] args) {

        BuyStrategy gildongBuyStrategy = new BuyRoe(); // Gildong의 매수 전략
        SellStrategy gildongSellStrategy = new SellTarget(); // Gildong의 매도 전략
        Gildong gildong = new Gildong(gildongBuyStrategy, gildongSellStrategy);

        // Minsu 객체 생성
        BuyStrategy minsuBuyStrategy = new BuyPer(); //Minsu의 매수 전략
        SellStrategy minsuSellStrategy = new SellTarget(); // Minsu의 매도 전략
        Minsu minsu = new Minsu(minsuBuyStrategy, minsuSellStrategy);

        System.out.println("\nMinsu's trading strategies:");
        minsu.buy();
        minsu.sell();

        System.out.println("Gildong's trading strategies:");
        gildong.buy();
        gildong.sell();

        // 동적으로 길동의 매수 전략 변경
        gildong.setBuyStrategy(new BuyPer());
        System.out.println("\nGildong's updated trading strategies:");
        gildong.buy();
        gildong.sell();

    }
}
