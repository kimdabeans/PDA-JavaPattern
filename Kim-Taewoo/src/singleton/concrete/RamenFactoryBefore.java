package singleton.concrete;

import singleton.framework.*;
import java.time.LocalDateTime;

/**
 * 패턴 적용 전의 라면 생산공장 
 */
public class RamenFactoryBefore extends FactoryBefore {
	/**
	 * 공장 이름을 저장하기 위한 변수 
	 */
	private String FactoryName;
	/**
	 * 라면 공장의 생성자 
	 * @param name 공장의 이름 
	 */
	public RamenFactoryBefore(String name) {
		FactoryName = name;
	}
	/**
	 * 라면을 생성하는 메서드
	 * 생성과 동시에 로깅을 한다 
	 * @return 생성된 라면 
	 */
	@Override
	protected ProductBefore createProduct(String name) {
		// TODO Auto-generated method stub
		ProductBefore ramen = new RamenBefore(name);
		logging(ramen);
		return ramen;
	}
	/**
	 * 생산 기록 메서드 
	 * @param product 생산 기록될 라면 
	 */
	@Override
	public void logging(ProductBefore product) {
		String log = LocalDateTime.now() + ", " + FactoryName + ", " + product.getName();
		System.out.println(log);
	}
}
