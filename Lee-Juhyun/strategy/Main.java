package strategy;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        // 숫자 설정
        student.changeNumber(9,12);

        // Calculator 설정
        student.setCalculator(new PlusCalculator());
        double result1 = student.operate();
        System.out.println(result1);


        // 새로운 Calculator 설정
        student.setCalculator(new MinusCalculator());
        double result2 = student.operate();
        System.out.println(result2);
    }
}
