package strategy;

public class PlusICalculator implements ICalculator {
    @Override
    public double execute(double n1, double n2) {
        return n1+n2;
    }
}
