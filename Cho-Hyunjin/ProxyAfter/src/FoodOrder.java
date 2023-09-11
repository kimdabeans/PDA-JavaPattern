/**
 * FoodOrder 인터페이스는 음식 주문과 관련된 동작을 정의합니다.
 */
public interface FoodOrder {
    /**
     * 주문 고객의 이름을 설정합니다.
     *
     * @param name 주문 고객의 이름
     */
    void setCustomerName(String name);

    /**
     * 주문 고객의 이름을 반환합니다.
     *
     * @return 주문 고객의 이름
     */
    String getCustomerName();

    /**
     * 주문을 생성하고 음식을 주문합니다.
     *
     * @param foodItem 주문하려는 음식 항목
     */
    void placeOrder(String foodItem);
}