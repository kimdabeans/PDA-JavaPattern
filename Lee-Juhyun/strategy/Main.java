package strategy;

/**
 * 전략 패턴을 사용하여 학생의 계산을 테스트하는 메인 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.changeNumber(9,12);

        // PlusCalculator를 선택하고 계산을 수행합니다.
        student.setCalculator(new PlusCalculator());
        double result1 = student.operate();
        System.out.println(result1);

        // MinusCalculator를 선택하고 계산을 수행합니다.
        student.setCalculator(new MinusCalculator());
        double result2 = student.operate();
        System.out.println(result2);
    }
}
