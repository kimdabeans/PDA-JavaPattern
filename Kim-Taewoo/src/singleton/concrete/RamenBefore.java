package singleton.concrete;

import singleton.framework.*;

/**
 * 패턴 적용 전 라면 클래스 
 */
public class RamenBefore extends ProductBefore {
	/**
	 * 라면의 이름 
	 */
	private String name;
	/**
	 * 라면의 생성자 
	 * @param name 라면의 이름 
	 */
	public RamenBefore(String name) {
		this.name = name;
		System.out.println(name + " 생성");
	}
	/**
	 * 라면의 이름을 반환 
	 * @return 라면 이름 
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
}
