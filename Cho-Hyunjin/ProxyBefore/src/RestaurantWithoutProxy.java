/**
 * RestaurantWithoutProxy 클래스는 주문 처리를 위한 식당 객체를 나타냅니다.
 */
public class RestaurantWithoutProxy {
    private String customerName;

    /**
     * RestaurantWithoutProxy 클래스의 생성자입니다.
     */
    public RestaurantWithoutProxy() {
        // 식당 객체 생성
    }

    /**
     * 고객의 이름을 설정합니다.
     *
     * @param name 설정할 고객 이름
     */
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    /**
     * 현재 설정된 고객의 이름을 반환합니다.
     *
     * @return 고객 이름
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 주문한 음식 항목을 처리하고 준비 과정을 시뮬레이션합니다.
     *
     * @param foodItem 주문한 음식 항목
     */
    public void placeOrder(String foodItem) {
        System.out.println("고객 " + customerName + "의 주문: " + foodItem + " 준비 중입니다.");
        // 음식 준비 시뮬레이션
        try {
            Thread.sleep(2000); // 2초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(foodItem + "가 완료되었습니다.");
    }
}