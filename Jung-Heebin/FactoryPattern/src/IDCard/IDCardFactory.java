/**
 * IDCard 생성하는 공장과 IDCard 상품을 표현하는 클래스를 포합합니다.
 */
package IDCard;

import FrameWork.Factory;
import FrameWork.Product;

/**
 * ID 카드를 생성하는 팩토리 클래스입니다.
 */
public class IDCardFactory extends Factory {

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + " is registered");
    }
}
