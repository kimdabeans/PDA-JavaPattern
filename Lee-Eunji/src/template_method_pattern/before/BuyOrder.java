package template_method_pattern.before;

/**
 * 주식 매수 주문을 나타내는 클래스입니다.
 * 이 클래스는 주식을 매수하기 위한 주문을 생성하고 처리하는 데 사용됩니다.
 *
 * @author Lee Eunji
 */
public class BuyOrder {

    private String stockSymbol; // 주식 심볼
    private int quantity; // 주문 수량
    private double price; // 주문 가격

    /**
     * BuyOrder 클래스의 생성자입니다.
     *
     * @param stockSymbol 주식 심볼
     * @param quantity    주문 수량
     * @param price       주문 가격
     */
    public BuyOrder(String stockSymbol, int quantity, double price) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * 매수 주문의 유효성을 검사하는 메소드입니다.
     * 예: 계좌 잔고 확인, 주식 가격 확인 등의 유효성 검사 로직이 수행됩니다.
     */
    public void validateOrder() {
        // 매수 주문 유효성 검사
        // 예: 계좌 잔고 확인, 주식 가격 확인 등
    }

    /**
     * 주식을 실제로 매수하는 로직을 수행하는 메소드입니다.
     * 예: 주식 거래소와 통신하여 주문 실행 등의 매수 로직이 수행됩니다.
     */
    public void placeOrder() {
        // 주식을 실제로 매수하는 로직
        // 예: 주식 거래소와 통신하여 주문 실행
    }

    /**
     * 매수 주문을 확정 처리하는 메소드입니다.
     * 예: 주문 번호 발급, 거래 내역 저장 등의 확정 처리 로직이 수행됩니다.
     */
    public void confirmOrder() {
        // 매수 주문 확정 처리
        // 예: 주문 번호 발급, 거래 내역 저장 등
    }
}
