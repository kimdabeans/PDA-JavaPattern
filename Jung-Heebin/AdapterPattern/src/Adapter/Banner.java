package Adapter;

/**
 * Banner 클래스는 특정 문자열을 괄호와 별표로 묶어서 출력하는 기능을 제공합니다.
 * 
 * <p>Banner 클래스의 메소드들은 printBanner클래스에 적용됩니다.</p>
 */
public class Banner {
    private String string;

    /**
     * 주어진 문자열을 이용하여 Banner 객체를 생성합니다.
     * @param string 출력할 문자열
     */
    public Banner(String string) {
        this.string = string;
    }

    /**
     * 문자열을 괄호로 묶어서 출력합니다.
     */
    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    /**
     * 문자열을 별표로 묶어서 출력합니다.
     */
    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
