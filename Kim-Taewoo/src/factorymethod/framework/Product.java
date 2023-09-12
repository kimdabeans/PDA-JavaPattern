package factorymethod.framework;

/**
 * 생산될 상품에 대한 추상클래스 
 */
public abstract class Product {
	/**
	 * 상품을 포장하는 추상 메서드 
	 */
	public abstract void packaging();
	/**
	 * 상품을 배송하는 추상 메서드 
	 * @param destination 배송할 목적지  
	 */
	public abstract void deliver(String destination);
}
