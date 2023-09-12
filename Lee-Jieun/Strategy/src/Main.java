import java.io.*;
import java.util.*;
import order.Order;
import payment.*;

/**
 * 주문 및 결제 처리를 위한 메인 클래스
 * @version 1.0
 * @author Lee Jieun
 */
public class Main {
	/**
	 * 책 번호와 가격을 매핑하는 HashMap
	 * 해당 예시에서는 책의 번호와 가격은 불변값이기 때문에 상수로 설정 
	 * */
	private static final Map<Integer, Integer> BOOK_LIST = new HashMap<>(); 
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Order order = new Order();
	private static Payment payment;

	/**
     * 목록 및 가격 설정을 위한 초기화 블록
     */
	 static {
		BOOK_LIST.put(1, 20000);
		BOOK_LIST.put(2, 23000);
		BOOK_LIST.put(3, 22000);
	}

	/**
	 * Strategy Pattern을 테스트하는 메인 함수 
	 * 
	 * @param args 프로그램을 실행할 때 넘겨주는 값
	 * @throws IOException 입출력 예외 발생 시 처리
	 * */
	public static void main(String[] args) throws IOException {
		
		//주문이 끝날때까지 반복 
		while (!order.isClosed()) {
			int cost; // 구매할 책의 누적 금액
			String continueChoice; // 계속 구매할 지 여부를 체크

			do {
				System.out.print("[ 구매 가능한 책 리스트 ]\n" + 
						"1. 모던 웹 애플리케이션\n" + 
						"2. 마이크로서비스 도입 이렇게 한다 \n" +
						"3. python을 이용한 개인화 추천 시스템\n");

				System.out.print("구매할 책 번호를 입력해주세요 >> ");
				int choice = Integer.parseInt(br.readLine()); // 구매할 책 번호
				cost = BOOK_LIST.get(choice); // 선택한 책 가격

				System.out.print("구매할 권수를 입력해주세요 >> ");
				int cnt = Integer.parseInt(br.readLine()); // 구매할 책 수량
				order.setTotal(cost * cnt); // 구매할 책의 누적 금액 

				System.out.print("다른 상품도 구매하시겠습니까?(Y/N) ");
				continueChoice = br.readLine(); // Y 또는 N 여부로 체크
				System.out.println(); // 간격 조정

			} while (continueChoice.equalsIgnoreCase("Y"));

			// 결제 수단이 등록되어 있지 않을 때 
			if (payment == null) { 
				System.out.println("[ 결제 방법 리스트 ]\n" + 
						"1. 체크카드\n" +
						"2. 신용카드\n" +
						"3. 희 Pay");

				System.out.print("결제 방법을 입력해주세요 >> ");
				String paymentMethod = br.readLine(); // 결제 방법
				System.out.println(); // 간격 조정

				if (paymentMethod.equals("1")) { //체크카드 결제 
					payment = new CheckCard();
				} else if(paymentMethod.equals("2")) { //신용카드 결제
					payment = new CreditCard();
				} else { //페이 결제 
					payment = new HeePay();
				} 
			} //if end 

			// 주문 처리 
			order.processOrder(payment); 

			// 결제 여부
			System.out.print("결제금액은 " + order.getTotal() + "원 입니다. 결제 하시겠습니까?(Y/N) ");
			String proceed = br.readLine();
			
			if (proceed.equalsIgnoreCase("Y")) {
				if (payment.isSuccess(order.getTotal())) {
					System.out.println("결제에 성공했습니다!");
				} else {
					System.out.println("결제에 실패했습니다. 등록 정보를 다시 확인해주세요.");
				}
			} else {
				System.out.println("결제를 취소하셨습니다.");
			} //if end 
			
			order.setClosed(); //주문 종료
		} //while end 
	}

}
