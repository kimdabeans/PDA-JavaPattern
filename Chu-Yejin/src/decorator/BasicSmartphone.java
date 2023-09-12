package decorator;

/**
 * 기본 스마트폰 클래스입니다.
 */
public class BasicSmartphone extends Smartphone {

    /**
     * 기본 스마트폰의 생성자입니다.
     */
    public BasicSmartphone() {
        description = "Basic Smartphone";
    }

    /**
     * 스마트폰의 가격을 반환하는 메서드입니다.
     *
     * @return 스마트폰의 가격
     */
    public double cost() {
        return 200.0;
    }
}