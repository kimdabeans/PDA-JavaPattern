package strategy;

/**
 * 계산기 기능을 정의하는 인터페이스입니다.
 * 이 인터페이스를 구현하는 클래스들은 실제 계산 로직을 구현해야 합니다.
 */
public interface ICalculator {
    /**
     * 두 개의 숫자를 입력받아 계산을 수행하는 메소드입니다.
     *
     * @param n1 첫 번째 숫자
     * @param n2 두 번째 숫자
     * @return 계산 결과
     */
    public  abstract double execute(double n1, double n2);
}
