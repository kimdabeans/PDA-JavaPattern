package strategy_pattern.example1.after;

/**
 * 옵션 매매 전략을 나타내는 구체적인 클래스입니다.
 *
 * @author Lee Eunji
 */
public class OptionsTradingStrategy implements TradingStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("옵션 매매 전략을 실행합니다.");
        // 옵션 매매에 대한 구체적인 로직을 구현합니다.
    }
}
