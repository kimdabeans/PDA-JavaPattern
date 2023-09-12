/**
 * 'OnState'는 앱이 활성화 상태일 때의 동작을 구현한 클래스
 */
class OnState implements AppState {
    /**
     * 주식 주문을 실행
     *
     * @param app 앱 객체
     * @param order 주문 객체
     * @param quantityExecuted 주문량
     */
    @Override
    public void orderStock(ShinhanAlphaApp app, StockOrder order, int quantityExecuted) {
        order.executeOrder(quantityExecuted);
    }
}
