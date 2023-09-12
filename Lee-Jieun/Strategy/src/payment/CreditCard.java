package payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 신용 카드 결제를 처리하는 클래스
 * @version 1.0
 * @author Lee Jieun
 */
public class CreditCard implements Payment {
	/**
	 * 사용자에게 값을 입력 받기 위해 사용 
	 * */
	private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	/**
	 * Card 객체 
	 * */
	private Card card;

	@Override
	public boolean isSuccess(int payment) {
		System.out.printf("%d 원 신용카드 결제를 시도하겠습니다.(카드번호: %s)\n\n", payment, card.getNumber());
		//card의 인스턴스가 생성되었다면 true, 아니면 false 
		return card != null ? true : false; 
	}

	/**
     * 신용 카드 결제에 필요한 카드 정보를 입력받고 카드 인스턴스를 생성하는 함수 
     */
	@Override
	public void payDetails() {
		try {
            System.out.print("카드 번호를 입력해주세요 >> ");
            String cardNumber = br.readLine();
            
            System.out.print("카드 만료일자를 입력해주세요(YY/MM) >> ");
            String cardDate = br.readLine();
            
            System.out.print("카드 비밀번호를 입력해주세요 >> ");
            String cardPwd = br.readLine();
            
            card = new Card(cardNumber, cardDate, cardPwd); // 카드 생성 

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
}
