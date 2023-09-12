/**
 * 주문이 취소된 상태를 나타내는 클래스
 */
class CancelledState implements OrderState {
    private StockOrder order;

    /**
     * 취소된 주문 상태 객체를 생성
     *
     * @param order 취소된 주문
     */
    public CancelledState(StockOrder order) {
        this.order = order;
    }

    /**
     * 주문을 실행하려고 시도할 때 호출 
     * 취소된 주문은 체결할 수 없으므로 경고 메시지 출력
     *
     * @param order 체결을 시도하는 주문
     * @param quantityExecuted 체결될 수량 (실제로는 체결되지 않음)
     */
    @Override
    public void executeOrder(StockOrder order, int quantityExecuted) {
        System.out.println("취소된 주문은 체결할 수 없습니다.");
    }

    /**
     * 주문 취소를 시도할 때 호출
     * 주문이 이미 취소된 상태이므로 경고 메시지 출력
     *
     * @param order 취소를 시도하는 주문
     */
    @Override
    public void cancelOrder(StockOrder order) {
        System.out.println("주문은 이미 취소되었습니다.");
    }

    /**
     * 현재 주문 상태를 출력
     */
    @Override
    public void printState() {
        System.out.println("주문 취소");
    }
}
