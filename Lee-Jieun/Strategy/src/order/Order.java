package order;

import payment.Payment;

/**
 * 주문 정보를 관리하는 클래스
 * @version 1.0
 * @author Lee Jieun
 * */
public class Order {
	/**
	 * 주문 누적 비용
	 * */
	private int total = 0;
	/**
	 * 주문이 종료 여부 
	 * */
    private boolean isClosed = false;

    /**
     * 결제 처리를 위해 Payments 객체에 결제 정보를 전달하는 함수 
     *
     * @param payment Payments 객체
     */
    public void processOrder(Payment payment) {
    	payment.payDetails();
    }

    /**
     * 주문 누적 비용에 책의 비용을 추가하는 함수
     *
     * @param cost 추가할 책의 비용
     */
    public void setTotal(int cost) {
        this.total += cost;
    }

    /**
     * 주문의 누적 비용을 반환하는 함수 
     *
     * @return 주문의 누적 비용
     */
    public int getTotal() {
        return total;
    }

    /**
     * 주문 종료 여부를 확인하는 함수 
     *
     * @return 주문이 종료 시 true, 아니면 false
     */
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * 주문 종료 상태로 설정하는 함수 
     */
    public void setClosed() {
        isClosed = true;
    }
}
