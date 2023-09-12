/**
 * 주문이 부분적으로만 체결된 상태를 나타내는 클래스
 */
class PartialExecutedState implements OrderState {
    private StockOrder order;

    /**
     * 부분 체결된 주문 상태 객체를 생성
     *
     * @param order 부분 체결된 주문
     */
    public PartialExecutedState(StockOrder order) {
        this.order = order;
    }

    /**
     * 주문을 실행
     * 이미 주문된 수량보다 체결된 수량이 작다면 부분 체결 상태를 유지하며,
     * 체결된 수량이 주문 수량과 동일하거나 크다면 주문 상태를 전체 체결 상태로 변경
     *
     * @param order 체결할 주문
     * @param quantityExecuted 체결될 수량
     */
    @Override
    public void executeOrder(StockOrder order,int quantityExecuted) {
        if (quantityExecuted < order.getQuantity()) {
            System.out.println(quantityExecuted + " 주식이 추가로 체결되었습니다.");
            order.reduceQuantity(quantityExecuted);
        } else {
            System.out.println("주문이 전체 체결되었습니다.");
            order.setState(new ExecutedState(order));
        }
    }

    /**
     * 남은 주문 취소
     * 주문 상태를 취소 상태로 변경
     *
     * @param order 취소할 주문
     */
    @Override
    public void cancelOrder(StockOrder order) {
        System.out.println("남은 주문이 취소되었습니다.");
        order.setState(new CancelledState(order));
    }

    /**
     * 현재 주문 상태를 출력
     */
    @Override
    public void printState() {
        System.out.println("주문 부분 체결");
    }
}

