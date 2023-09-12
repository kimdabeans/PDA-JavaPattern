/**
 * key를 생성하는 공장과 key 상품을 표현하는 클래스를 포합합니다.
 */
package Key;

import FrameWork.Product;

/**
 * 열쇠를 나타내는 클래스입니다.
 */
public class Key extends Product {
    private String owner;

    /**
     * 지정된 소유자로 열쇠를 생성합니다.
     *
     * @param owner 열쇠의 소유자입니다.
     */
    public Key(String owner) {
        System.out.println(owner + "\'s Key is on production at the key factory");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner + " using the key");
    }

    @Override
    public String toString() {
        return owner;
    }
}
