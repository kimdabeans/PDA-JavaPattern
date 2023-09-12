package abstract_factory_pattern;

/**
 * <p>
 * 휴대폰으로 실행 가능한 기능이 정의된 Phone 인터페이스이다. <br>
 * 전화 기능인 call 메서드와, 게임 기능인 playGame 메서드로 구성된다. 
 * </p>
 * @author 서준원
 *
 */
public interface Phone {
	
	/**
	 * 휴대폰의 전화 기능
	 */
    public void call();

    /**
     * 휴대폰의 게임 기능 
     */
    public void playGame();
}
