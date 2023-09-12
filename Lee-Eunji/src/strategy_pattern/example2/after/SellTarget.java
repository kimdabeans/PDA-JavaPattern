package strategy_pattern.example2.after;

/**
 * 목표 가격에 도달했을 때 주식을 매도하는 전략을 구현한 클래스입니다.
 *
 * @author Lee Eunji
 */
public class SellTarget implements SellStrategy {
    @Override
    public void sell() {
        System.out.println("by target");
    }
}
