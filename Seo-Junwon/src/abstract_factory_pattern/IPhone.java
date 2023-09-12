package abstract_factory_pattern;

/**
 * 휴대폰의 기능이 정의된 Phone 인터페이스를 구현한 IPhone 클래스
 * Phone 인터페이스의 call, playGame 메서드를 override 해 아이폰 자체 기능 재정의.
 * 
 * @author 서준원
 *
 */
public class IPhone implements Phone{
	
	/*
	 * 아이폰의 전화 기능
	 */
    @Override
    public void call() {
        System.out.println("아이폰으로 전화 실행");
    }

    /**
     * 아이폰의 게임 기능 
     */
    @Override
    public void playGame() {
        System.out.println("아이폰으로 게임 실행");
    }
}
