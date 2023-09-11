// FoodOrderProxy 클래스 (프록시)
public class FoodOrderProxy implements FoodOrder {
    private String customerName;
    private Restaurant real;

    public FoodOrderProxy() {
        this.customerName = "미정";
        this.real = null;
    }

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

    private void realize() {
        if (real == null) {
            real = new Restaurant();
            real.setCustomerName(customerName);
        }
    }
}