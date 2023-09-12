/**
 * key를 생성하는 공장과 key 상품을 표현하는 클래스를 포합합니다.
 */
package Key;

import FrameWork.Factory;
import FrameWork.Product;

/**
 * 열쇠를 생성하는 팩토리 클래스입니다.
 */
public class KeyFactory extends Factory {

    @Override
    protected Product createProduct(String owner) {
        return new Key(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + " is registered");
    }
}
