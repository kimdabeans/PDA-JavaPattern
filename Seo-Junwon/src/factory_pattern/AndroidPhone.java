package factory_pattern;
/**
 * <p>
 * 휴대폰의 기능을 정의한 Phone 인터페이스를 구현한 AndroidPhone 구현체 클래스이다.<br>
 * 휴대폰을 완성하는 complete 메서드와 휴대폰을 통해 전화를 하는 call 메서드로 구성된다.
 * </p>
 * @author 서준원
 *
 */
public class AndroidPhone implements Phone{
	
	/**
	 * 안드로이드 폰이 생성되었음을 알려주는 메서드
	 */
	@Override
    public void complete() {
        System.out.println("안드로이드폰 완성");
    }

	/**
	 * 안드로이드 폰의 전화 기능이 실행되었음을 알려주는 메서드
	 */
    @Override
    public void call() {
        System.out.println("안드로이드폰으로 전화를 한다");
    }
}
