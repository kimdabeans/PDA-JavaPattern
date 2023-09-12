package abstract_factory_pattern;

/**
 * <p>
 * 휴대폰의 기능이 정의된 Phone 인터페이스를 구현한 AndroidPhone 클래스이다. <br>
 * Phone 인터페이스의 call, playGame 메서드를 override 해 아이폰 자체 기능 재정의 한다.
 * </p>
 * @author 서준원
 *
 */
public class AndroidPhone implements Phone{
	
	/*
	 * 안드로이드 폰의 전화 기능
	 */
	@Override
    public void call() {
        System.out.println("안드로이드로 전화 실행");
    }

	/*
	 * 안드로이드 폰의 게임 기능
	 */
    @Override
    public void playGame() {
        System.out.println("안드로이드로 게임 실행");
    }
}
