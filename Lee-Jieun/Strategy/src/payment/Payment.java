package payment;

/**
 * 결제 처리를 위한 메서드를 정의하는 결제 인터페이스
 */
public interface Payment {
	/**
     * 결제가 성공 여부를 확인하는 함수
     *
     * @param payment 결제할 금액
     * @return 결제가 성공 시 true, 아니면 false
     */
	public boolean isSuccess(int payment);
	/**
     * 결제에 필요한 카드 또는 Pay 정보를 입력받는 함수 
     */
	public void payDetails();
}
