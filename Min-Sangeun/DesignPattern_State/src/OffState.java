/**
 * 'OffState'는 앱이 비활성화 상태일 때의 동작을 구현한 클래스
 */
class OffState implements AppState {
    /**
     * 앱이 꺼져 있을 때 주식 주문을 할 수 없다는 메시지 출력
     *
     * @param app 앱 객체
     * @param order 주문 객체
     * @param quantityExecuted 주문량
     */
    @Override
    public void orderStock(ShinhanAlphaApp app, StockOrder order, int quantityExecuted) {
        System.out.println("앱이 꺼져 있어서 주식 주문을 할 수 없습니다.");
    }
}