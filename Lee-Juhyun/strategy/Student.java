package strategy;

public class Student {
    private ICalculator ICalculator;
    private double n1;
    private double n2;

    public double operate(){
        return ICalculator.execute(n1,n2);
    }

    public void setCalculator(ICalculator ICalculator){
        this.ICalculator = ICalculator;
    }

    public void changeNumber(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
