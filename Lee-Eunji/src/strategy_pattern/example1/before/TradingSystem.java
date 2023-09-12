package strategy_pattern.example1.before;

/**
 * 금융 거래 시스템을 나타내는 클래스입니다.
 */
public class TradingSystem {
    /**
     * 주식 거래 전략을 나타내는 정수 상수입니다.
     */
    public static final int STOCK = 0;
    /**
     * 선물 거래 전략을 나타내는 정수 상수입니다.
     */
    public static final int FUTURES = 1;
    /**
     * 옵션 거래 전략을 나타내는 정수 상수입니다.
     */
    public static final int OPTIONS = 2;

    private int state;

    /**
     * 거래 전략을 설정합니다.
     *
     * @param state 거래 전략을 나타내는 정수 상수
     */
    public void setStrategy(int state) {
        this.state = state;
    }

    /**
     * 설정된 거래 전략을 실행합니다.
     */
    public void executeTrading() {
        if (state == STOCK) {
            System.out.println("주식 매매 전략을 실행합니다.");
        } else if (state == FUTURES) {
            System.out.println("선물 매매 전략을 실행합니다.");
        } else if (state == OPTIONS) {
            System.out.println("옵션 매매 전략을 실행합니다.");
        }
    }
}
