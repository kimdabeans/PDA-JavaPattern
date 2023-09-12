import java.util.ArrayList;
import java.util.List;

/**
 * 주식 주문 클래스
 */
class StockOrder {
    private OrderState state;
    private int quantity;
    private double price;
    private List<String> stateHistory = new ArrayList<>();

    /**
     * 주식 주문 객체를 생성하고 초기 상태를 '대기 중'으로 설정
     *
     * @param quantity 주문할 주식의 수량
     * @param price 주식의 가격
     */
    public StockOrder(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
        this.state = new PendingState(this);
        stateHistory.add("주문 생성: 대기 중");
    }

    /**
     * 현재 주문 수량을 반환
     *
     * @return 주문 수량
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * 주문 수량을 줄인다.
     *
     * @param quantity 감소시킬 주식의 수량
     */
    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    /**
     * 주문의 상태를 설정
     *
     * @param state 설정할 주문의 상태
     */
    public void setState(OrderState state) {
        this.state = state;
    }

    /**
     * 주문의 상태 변경 기록을 추가
     *
     * @param state 추가할 상태 문자열
     */
    public void addStateToHistory(String state) {
        stateHistory.add(state);
    }

    /**
     * 주문 실행
     *
     * @param quantityExecuted 체결될 주식의 수량
     */
    public void executeOrder(int quantityExecuted) {
        state.executeOrder(this, quantityExecuted);
    }

    /**
     * 주문 취소
     */
    public void cancelOrder() {
        state.cancelOrder(this);
    }

    /**
     * 현재 주문 상태를 출력
     */
    public void printState() {
        state.printState();
    }


    /**
     * 주문의 상태 변경 기록 전체를 출력
     */
    public void printOrderHistory() {
        for (String hist : stateHistory) {
            System.out.println(hist);
        }
    }
}
