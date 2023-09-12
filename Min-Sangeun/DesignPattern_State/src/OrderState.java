/**
 * 주문 상태를 나타내는 인터페이스 
 * 주문의 다양한 상태에 따른 행동을 정의
 */
interface OrderState {

    /**
     * 주문을 체결하려고 할 때 호출되는 메서드
     *
     * @param order 체결을 시도하는 주문 객체
     * @param quantityExecuted 체결을 시도하는 주문 수량
     */
    void executeOrder(StockOrder order, int quantityExecuted);

    /**
     * 주문 취소를 시도할 때 호출되는 메서드
     *
     * @param order 취소를 시도하는 주문 객체
     */
    void cancelOrder(StockOrder order);

    /**
     * 현재 주문 상태를 출력하는 메서드
     */
    void printState();
}


