package abstract_factory_pattern;

/**
 * <p>
 * OS의 기능이 정의된 OS 인터페이스를 구현한 구글 OS 클래스이다. 
 * </p>
 * @author 서준원
 *
 */
public class GoogleOS implements OS {
    @Override
    public void installOS() {
        System.out.println("구글OS 설치");
    }
}
