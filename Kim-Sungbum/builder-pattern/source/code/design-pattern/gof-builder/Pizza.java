
/**
 * 이 클래스는 피자 객체를 나타내는 클래스입니다.
 */
public class Pizza {
    /**
     * 피자의 도우 종류를 나타내는 문자열입니다.
     */
    private String dough;

    /**
     * 피자의 소스 종류를 나타내는 문자열입니다.
     */
    private String sauce;

    /**
     * 피자의 토핑 종류를 나타내는 문자열입니다.
     */
    private String topping;

    /**
     * 피자 객체의 문자열 표현을 반환합니다.
     *
     * @return 피자 객체의 문자열 표현
     */
    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}
