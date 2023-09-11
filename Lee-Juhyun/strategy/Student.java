package strategy;

public class Student {
    private Calculator calculator;
    private double n1;
    private double n2;

    public double operate(){
        return calculator.execute(n1,n2);
    }

    public void setCalculator(Calculator calculator){
        this.calculator=calculator;
    }

    void changeNumber(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
