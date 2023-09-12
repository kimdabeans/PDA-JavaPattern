package food;

import framework.*;

/**
 * Product 클래스를 상속하여 만든, Factory에서 만들고자 하는 FishBread 클래스입니다.
 */
public class FishBread extends Product{
	
	/**
	 * FishBread의 주재료에 대한 정보를 저장하는 변수입니다.
	 */
	private String ingredient;
	
	/**
	 * FishBread 생성자
	 * 
	 * @param ingredient FishBread의 주재료
	 */
	FishBread(String ingredient) {
		System.out.println(ingredient + "맛 붕어빵을 만듭니다.");
		this.ingredient = ingredient;
	}
	
	/**
	 * Product에 정의된 추상 메서드를 Override합니다.
	 * FishBread 사용에 대한 정보를 콘솔창에 출력합니다.
	 */
	@Override
	public void use() {
		System.out.println(this + "을 먹었습니다!!");
	}
	
	/**
	 * toString 메서드를 Overriding하여, FishBread에 대한 정보와 인스턴스의 ingredient를 하나의 string값으로 리턴합니다.
	 * 
	 * @return FishBread 인스턴스에 대한 정보와 인스턴스의 ingredient를 하나의 string값으로 리턴합니다.
	 */
	@Override
	public String toString() {
		return "["+ ingredient + " 붕어빵]";
	}
	
	/**
	 * FishBread의 ingredient를 리턴합니다.
	 * 
	 * @return 현재 FishBread의 ingredient를 리턴합니다.
	 */
	public String getIngredient() {
		return this.ingredient;
	}
}
