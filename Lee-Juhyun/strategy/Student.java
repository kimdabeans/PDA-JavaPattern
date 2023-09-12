package strategy;

/**
 * 학생 클래스는 계산기 전략을 선택하고 계산을 수행하는 역할을 합니다.
 * 또한 숫자를 변경할 수 있습니다.
 */
public class Student {
    private ICalculator ICalculator;
    private double n1;
    private double n2;

    /**
     * 선택한 계산기 전략을 사용하여 계산을 수행합니다.
     *
     * @return 계산 결과
     */
    public double operate(){
        return ICalculator.execute(n1,n2);
    }

    /**
     * 사용할 계산기 전략을 설정합니다.
     *
     * @param ICalculator 선택한 계산기 전략
     */
    public void setCalculator(ICalculator ICalculator){
        this.ICalculator = ICalculator;
    }

    /**
     * 학생의 숫자를 변경합니다.
     *
     * @param n1 첫 번째 숫자
     * @param n2 두 번째 숫자
     */
    public void changeNumber(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
