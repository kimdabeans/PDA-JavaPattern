package payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Hee Pay 결제를 처리하는 클래스
 * @version 1.0
 * @author Lee Jieun
 */
public class HeePay implements Payment {
	/**
	 * Pay 아이디와 비밀번호를 매핑하는 HashMap
	 * */
	private static final Map<String, String> HEEPAY_INFO = new HashMap<>();
	/**
	 * 사용자에게 값을 입력 받기 위해 사용 
	 * */
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Pay 아이디
     * */
    private String userId;
    /**
     * Pay 비밀번호
     * */
    private String userPW;
    /**
     * 록된 유저 정보가 맞는 지 유무
     * */
    private boolean correct;
    
    /**
     * Hee Pay 사용자 정보 등록을 위한 초기화 블록
     */
    static {
    	HEEPAY_INFO.put("jieun0714", "eun1234");
    	HEEPAY_INFO.put("sanghee1002", "hee0238");
    }
    
	@Override
	public boolean isSuccess(int payment) {
		System.out.println(payment + "원 희 Pay 결제를 시도하겠습니다.\n");
		return correct; 
	}

	/**
     * 결제에 필요한 사용자 정보를 입력받고, 등록된 유저가 맞는 지 확인하는 함수 
     */
	@Override
	public void payDetails() {
		try {
            while (!correct) {
                System.out.print("아이디를 입력해주세요 >> ");
                userId = br.readLine();
                
                System.out.print("비밀번호를 입력해주세요 >> ");
                userPW = br.readLine();
                 
                setCorrect(userPW.equals(HEEPAY_INFO.get(userId)));
                // 등록된 유저 정보가 맞는 지 체크 
                if (correct) {
                    System.out.println("등록된 Pay입니다. 결제를 시도하겠습니다.");
                } else {
                	System.out.println("틀린 정보입니다. 다시 입력해주세요.");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	private void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
