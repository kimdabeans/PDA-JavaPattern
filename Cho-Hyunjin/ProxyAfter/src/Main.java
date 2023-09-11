/**
 * 주문 테스트를 위한 클래스입니다. FoodOrderProxy를 사용하여 주문 처리 과정을 시뮬레이션합니다.
 */
public class Main {
    /**
     * 프로그램의 진입점입니다.
     *
     * @param args 커맨드 라인 인수 (사용되지 않음)
     */
    public static void main(String[] args) {
        // FoodOrderProxy를 사용하여 주문 처리 과정을 시뮬레이션합니다.
        FoodOrder order = new FoodOrderProxy("Jinny");

        // 현재 주문자 이름을 출력합니다.
        System.out.println("현재 주문자 이름: " + order.getCustomerName());

        // 주문자의 이름을 변경하고 변경된 이름을 출력합니다.
        order.setCustomerName("Daniel");
        System.out.println("현재 주문자 이름: " + order.getCustomerName());

        // 주문을 생성하여 음식 주문을 처리합니다.
        order.placeOrder("피자");
    }
}
