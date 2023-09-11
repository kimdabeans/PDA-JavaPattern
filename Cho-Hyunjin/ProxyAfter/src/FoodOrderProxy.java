/**
 * FoodOrderProxy 클래스는 FoodOrder 인터페이스를 구현하며, 프록시 역할을 수행합니다.
 */
public class FoodOrderProxy implements FoodOrder {
    /**
     * 주문 고객의 이름을 나타내는 변수
     */
    private String customerName;

    /**
     * 실제 식당 객체를 참조하는 변수
     */
    private Restaurant real;

    /**
     * FoodOrderProxy 클래스의 기본 생성자입니다.
     * 주문 고객의 이름을 "미정"으로 초기화하고 실제 식당 객체를 초기화하지 않습니다.
     */
    public FoodOrderProxy() {
        this.customerName = "미정";
        this.real = null;
    }

    /**
     * FoodOrderProxy 클래스의 생성자입니다.
     *
     * @param customerName 주문 고객의 이름
     */
    public FoodOrderProxy(String customerName) {
        this.customerName = customerName;
        this.real = null;
    }

    @Override
    public void setCustomerName(String name) {
        if (real != null) {
            real.setCustomerName(name);
        }
        this.customerName = name;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void placeOrder(String foodItem) {
        realize();
        real.placeOrder(foodItem);
    }

    /**
     * 실제 객체를 생성하고 주문자의 이름을 설정합니다.
     */
    private void realize() {
        if (real == null) {
            real = new Restaurant();
            real.setCustomerName(customerName);
        }
    }
}