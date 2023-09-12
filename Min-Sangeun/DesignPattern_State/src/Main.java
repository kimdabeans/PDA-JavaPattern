public class Main {
    public static void main(String[] args) {
        ShinhanAlphaApp app = new ShinhanAlphaApp();

        // 앱을 켜지 않은 상태에서 주문 시도
        StockOrder order1 = new StockOrder(100, 5000);
        app.orderStock(order1, 50);

        // 앱을 켜기
        app.turnOn();

        // 주문 대기 중 상태에서 주문 생성 및 체결 시도
        StockOrder order2 = new StockOrder(100, 6000);
        order2.printState(); // 주문 대기 중 출력
        app.orderStock(order2, 50); // 50 주식 체결
        order2.printState(); // 주문 부분 체결 출력

        // 부분 체결 상태에서 추가 체결
        app.orderStock(order2, 40); // 추가 40 주식 체결
        order2.printState(); // 주문 부분 체결 출력

        // 주문 완료 상태로 변경
        app.orderStock(order2, 10); // 나머지 10 주식 체결
        order2.printState(); // 주문 체결 출력

        // 주문 취소 시도
        order2.cancelOrder(); // 체결된 주문은 취소할 수 없습니다. 출력

        // 취소 상태로 변경하기 위해 새로운 주문 생성
        StockOrder order3 = new StockOrder(100, 7000);
        order3.cancelOrder(); // 주문이 취소되었습니다. 출력
        order3.printState(); // 주문 취소 출력
    }
}
