package Before;

/**
 * Factory Method 디자인 패턴을 쓰긴 전 코드이다.
 * 고객의 계좌(Account)를 나타내는 클래스이다.
 *  
 * @author  Jang Jeong Eun
 * @version 1.0, 08 Sep 2023
 */

public class Account {

	    private String owner;
	    
	    /**
	     * 주어진 소유자 정보로 계좌(Account) 객체를 생성 및 등록한 후 결과를 출력한다.
	     *
	     * @param owner 계좌의 소유자 정보
	     */
	    public Account(String owner) {
	        this.owner = owner;
	        System.out.println(owner + "의 계좌를 만듭니다.");
	        System.out.println(owner + "을 등록했습니다.");
	    }
	    
	    /**
	     * 계좌를 사용하는 메서드로 사용되는 계좌를 출력한다.
	     */
	    public void use() {
	        System.out.println(owner + "의 계좌를 사용합니다.");
	    }
	}

