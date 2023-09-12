package strategy;

/**
 * ICalculator 인터페이스를 구현하여 두 숫자의 덧셈을 수행하는 클래스입니다.
 */
public class PlusCalculator implements ICalculator {
    @Override
    public double execute(double n1, double n2) {
        return n1+n2;
    }
}
