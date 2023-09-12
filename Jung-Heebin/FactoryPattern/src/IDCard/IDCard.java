/**
 * IDCard 생성하는 공장과 IDCard 상품을 표현하는 클래스를 포합합니다.
 */
package IDCard;

import FrameWork.Product;

/**
 * ID 카드를 나타내는 클래스입니다.
 */
public class IDCard extends Product {
    private String owner;

    /**
     * 지정된 소유자로 ID 카드를 생성합니다.
     *
     * @param owner ID 카드의 소유자입니다.
     */
    public IDCard(String owner) {
        System.out.println(owner + "\'s IDCard is on production at the IDCard factory");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner + "using the IDCard");
    }

    @Override
    public String toString() {
        return owner;
    }

    /**
     * ID 카드의 소유자를 반환합니다.
     *
     * @return ID 카드의 소유자입니다.
     */
    public String getOwner() {
        return owner;
    }
}
