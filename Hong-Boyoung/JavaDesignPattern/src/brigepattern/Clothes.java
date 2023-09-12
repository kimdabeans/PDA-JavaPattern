package brigepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 의류를 나타내는 추상 클래스.
 *
 * 이 클래스는 온라인 쇼핑몰의 시스템 구조를 정의하며 서비스에 대한 작업을 수행할 수 있도록 합니다.
 */

public abstract class Clothes {
    /**
     * 소비자가 의류 쇼핑시 이용할 수 있는 서비스를 저장하는 리스트.
     */
    protected List<ShoppingService> shoppingServices = new ArrayList<ShoppingService>();
    /**
     * 기본 생성자.
     */
    public Clothes() {
        super();
    }
    /**
     * 소비자가 의류 선택 후 이용할 수 있는 서비스를 추가한 메서드.
     *
     * @param shoppingservice 이용할 쇼핑 서비스.
     * @return 쇼핑 서비스 이용 성공 시 true, 실패 시 false.
     */
    public boolean addShoppingService(ShoppingService shoppingservice) {
        return shoppingServices.add(shoppingservice);
    }
    /**
     * 쇼핑 후 이용할 수 있는 서비스의 추상 메서드.
     */
    public abstract void selectService();
    /**
     * 쇼핑 후 서비스 이용시간을 반환하는 추상 메서드.
     *
     * @return 작업 시간 (분 단위).
     */
    public abstract int takeTime();

}

