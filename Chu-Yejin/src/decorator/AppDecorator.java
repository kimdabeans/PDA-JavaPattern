package decorator;

/**
 * 스마트폰에 추가 앱을 데코레이팅하는 역할을 합니다.
 */
public abstract class AppDecorator extends Smartphone {

    /**
     * 앱의 설명을 반환하는 추상 메서드입니다.
     *
     * @return 앱의 설명 문자열
     */
    public abstract String getDescription();
}