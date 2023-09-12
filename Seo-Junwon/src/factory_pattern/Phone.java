package factory_pattern;

/**
 * 휴대폰의 기능을 정의한 Phone 인터페이스
 * 
 * @author 서준원
 *
 */
public interface Phone {
	
	/**
	 * 휴대폰 생성이 완료됐음을 알려주는 메서드
	 */
	void complete();
	
	/**
	 * 휴대폰의 전화 기능을 나타내는 메서드
	 */
    void call();
    
}
