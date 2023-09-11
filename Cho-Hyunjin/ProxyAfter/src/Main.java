public class Main {
    public static void main(String[] args) {
        FoodOrder order = new FoodOrderProxy("Jinny");
        System.out.println("현재 주문자 이름: " + order.getCustomerName());
        order.setCustomerName("Daniel");
        System.out.println("현재 주문자 이름: " + order.getCustomerName());
        order.placeOrder("피자");
    }
}