package Adapter;

/**
* PrintBanner 클래스는 Print 클래스를 상속받아 Banner를 이용하여 출력 기능을 제공합니다.
* 
* <p>추상 메소드를 오버라이드 할 때, Banner클래스를 적용합니다.</p>
*/
public class PrintBanner extends Print {
    private Banner banner;

    /**
     * 주어진 문자열을 이용하여 PrintBanner 객체를 생성합니다.
     * @param string 출력할 문자열
     */
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    /**
     * Banner 클래스의 메소드를 이용하여 문자열을 괄호로 묶어서 출력합니다.
     * @see Banner#showWithParen()
     */
    @Override
    public void printWaek() {
        banner.showWithParen();
    }

    /**
     * Banner 클래스의 메소드를 이용하여 문자열을 별표로 묶어서 출력합니다.
     * @see Banner#showWithAster()
     */
    @Override
    public void pirntStrong() {
        banner.showWithAster();
    }
}