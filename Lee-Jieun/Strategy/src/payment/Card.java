package payment;

/**
 * 카드의 정보를 나타내는 클래스
 * @version 1.0
 * @author Lee Jieun
 */
public class Card {
	/**
	 * 카드 번호 
	 * */
    private String number;
    /**
     * 카드 만료 날짜
     * */
    private String date;
    /**
     * 카드 비밀번호
     * */
    private String password;

    /**
     * Card 클래스의 생성자
     *
     * @param number   카드 번호
     * @param date     카드 만료일자
     * @param password 카드 비밀번호
     */
    Card(String number, String date, String password) {
        this.number = number;
        this.date = date;
        this.password = password;
    }

    /**
     * 카드 번호 반환
     *
     * @return 카드 번호
     */
	public String getNumber() {
		return number;
	}

	/**
     * 카드 만료일자 반환  
     *
     * @return 카드 만료일자
     */
	public String getDate() {
		return date;
	}
	
	/**
     * 카드 비밀번호 반환 
     *
     * @return 카드 비밀번호
     */
	public String getPassword() {
		return password;
	}
    
}
