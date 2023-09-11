public class Restaurant implements FoodOrder {
    private String customerName;

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