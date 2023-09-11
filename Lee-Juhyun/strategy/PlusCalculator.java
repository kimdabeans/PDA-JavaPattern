package strategy;

public class PlusCalculator implements Calculator{
    @Override
    public double execute(double n1, double n2) {
        return n1+n2;
    }
}
