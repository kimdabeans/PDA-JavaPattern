/**
 * Restaurant 클래스는 FoodOrder 인터페이스를 구현한 실제 식당 클래스입니다.
 */
public class Restaurant implements FoodOrder {
    /**
     * 주문 고객의 이름을 나타내는 변수
     */
    private String customerName;

    /**
     * Restaurant 클래스의 기본 생성자입니다.
     * (식당 객체 생성 과정은 설명에서 생략되었습니다.)
     */
    public Restaurant() {
        // 식당 객체 생성
    }

    @Override
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
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
