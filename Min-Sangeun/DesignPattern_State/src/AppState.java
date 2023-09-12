/**
 * 'AppState'는 앱의 상태에 따른 주식 주문 동작을 정의하는 인터페이스
 */
interface AppState {

    /**
     * 주식 주문 동작을 수행하는 메서드
     *
     * @param app 주문을 수행하는 앱의 객체
     * @param order 주식 주문 객체
     * @param quantityExecuted 주문하려는 주식의 수량
     */
    void orderStock(ShinhanAlphaApp app, StockOrder order, int quantityExecuted);
}


