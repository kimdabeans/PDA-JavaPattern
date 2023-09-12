package factory.idcard;

import factory.framework.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ID 카드를 생성하고 관리하는 팩토리 클래스.
 */
public class IDCardFactory extends Factory{
    private List owners = new ArrayList();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    /**
     * 지금까지 생성된 모든 카드 소유주의 리스트를 반환합니다.
     * @return 소유주 리스트
     */
    public List getOwners() {
        return this.owners;
    }
}
