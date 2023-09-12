/**
 * 이 클래스는 주문을 처리하는 데 사용되는 식당 객체를 나타냅니다.
 */
public class MainWithoutProxy {
    /**
     * 주문 처리를 위한 메인 메소드입니다.
     */
    public static void main(String[] args) {
        // 식당 객체 생성
        RestaurantWithoutProxy restaurant = new RestaurantWithoutProxy();
        
        // 고객의 이름 설정
        restaurant.setCustomerName("Jinny");
        System.out.println("현재 주문자 이름: " + restaurant.getCustomerName());
        
        // 주문 처리
        restaurant.placeOrder("피자");
    }
}