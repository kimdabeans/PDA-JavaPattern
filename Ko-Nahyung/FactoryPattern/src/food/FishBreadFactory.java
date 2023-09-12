package food;

import framework.*;

/**
 * Factory 클래스를 상속하여 만든, FishBread를 만드는 FishBreadFactory 클래스입니다.
 */
public class FishBreadFactory extends Factory{
	
	/**
	 * Factory에 정의된 추상 메소드 createProduct를 Override합니다.
	 * FishBread 인스턴스를 생성하여 리턴합니다.
	 * 
	 * @param ingredient FishBread의 ingredient
	 * @return ingredient을 parameter로하여 생성한 FishBread 인스턴스를 리턴합니다.
	 */
	@Override
	protected Product createProduct(String ingredient) {
		return new FishBread(ingredient);
	}
	
	/**
	 * Factory에 정의된 추상 메소드 registerProduct를 Override합니다.
	 * FishBread 정보와 FishBread 등록에 대한 정보를 콘솔창에 출력합니다.
	 * 
	 * @param product Product를 상속하는 FishBread
	 */
	@Override
	protected void registerProduct(Product product) {
		System.out.println(product + "굽는중...완성!\n");
	}
}
