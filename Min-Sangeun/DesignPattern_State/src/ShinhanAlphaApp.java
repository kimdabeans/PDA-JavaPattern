/**
 * 'ShinhanAlphaApp'는 신한 알파 앱의 주요 기능을 구현한 클래스
 */
class ShinhanAlphaApp {
    private AppState state;

    /**
     * 신한 알파 앱을 초기화하며, 기본 상태를 Off로 설정
     */
    public ShinhanAlphaApp() {
        this.state = new OffState();
    }

    /**
     * 앱의 상태를 설정
     *
     * @param state 설정할 앱 상태
     */
    public void setState(AppState state) {
        this.state = state;
    }

    /**
     * 주식 주문을 실행
     *
     * @param order 주문 객체
     * @param quantityExecuted 주문량
     */
    public void orderStock(StockOrder order, int quantityExecuted) {
        state.orderStock(this, order, quantityExecuted);
    }

    /**
     * 앱을 켭니다.
     */
    public void turnOn() {
        this.setState(new OnState());
        System.out.println("앱을 켰습니다.");
    }

    /**
     * 앱을 끕니다.
     */
    public void turnOff() {
        this.setState(new OffState());
        System.out.println("앱을 껐습니다.");
    }
}

