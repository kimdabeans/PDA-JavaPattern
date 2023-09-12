package singleton.concrete;

import singleton.FactoryLogger;
import singleton.framework.*;
import java.time.LocalDateTime;

/**
 * 패턴 적용 후 라면 생산공장 
 */
public class RamenFactoryAfter extends FactoryAfter {
	/**
	 * 공장 이름을 저장하기 위한 변수 
	 */
	private String FactoryName;
	/**
	 * 라면 공장의 생성자 
	 * @param name 공장의 이름 
	 */
	public RamenFactoryAfter(String name) {
		FactoryName = name;
	}
	/**
	 * 라면을 생성하는 메서드
	 * 생성과 동시에 로깅을 한다 
	 * @return 생성된 라면 
	 */
	@Override
	protected ProductAfter createProduct(String name) {
		// TODO Auto-generated method stub
		ProductAfter ramen = new RamenAfter(name);
		logging(ramen);
		return ramen;
	}
	/**
	 * 생산 기록 메서드 
	 * @param product 생산 기록될 라면 
	 */
	@Override
	public void logging(ProductAfter product) {
		FactoryLogger.getInstance().addLog(LocalDateTime.now() + ", " + FactoryName + ", " + product.getName());
	}

}
