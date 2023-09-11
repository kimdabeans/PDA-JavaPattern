package Strategy;

public enum Stock {
    LOWER_PRICE(1000),
    REGULAR_PRICE(2000),
    UPPER_PRICE(3000);

    private int price;
    private Stock(int price) {
        this.price = price;
    }
}
