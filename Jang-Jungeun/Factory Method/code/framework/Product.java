package framework;

/**
 * 제품을 나타내는 추상클래스
 * 추상 메소드 use만 선언되어 있음. 구체적인 use의 구현은 Product의 하위 클래스에 맡김.
 * 
 * @author  Jang Jeong Eun
 * @version 1.1, 08 Sep 2023
 */


public abstract class Product {
    /**
     * 하위 클래스에서 제품의 사용 방법을 정의해야 하는 use 메서드입니다.
     */
	public abstract void use();
}
