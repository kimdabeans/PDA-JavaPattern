package decorator;

/**
 * 스마트폰을 나타내는 추상클래스입니다.
 */
public abstract class Smartphone {
    protected String description = "Smartphone";

    /**
     * 스마트폰의 설명을 반환하는 메서드입니다.
     *
     * @return 스마트폰의 설명 문자열
     */
    public String getDescription() {
        return description;
    }

    /**
     * 스마트폰의 가격을 반환하는 추상 메서드입니다.
     *
     * @return 스마트폰의 가격
     */
    public abstract double cost();
}