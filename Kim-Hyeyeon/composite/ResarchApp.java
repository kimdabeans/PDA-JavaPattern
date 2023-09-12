package composite;
/**
 * 메인 클래스. 
 * 
 * PersonalStock, PersonalPortfolio의 인스턴스를 생성하고
 * 주식을 포트폴리오에 추가한 후 포트폴리오의 총 가격 및 종목명을 출력
 */
public class ResarchApp {

	public static void main(String[] args) {
		PersonalStock shinhan = new PersonalStock("Shinhan", 36450.0);
		PersonalStock naver = new PersonalStock("Naver", 211500.0);
		PersonalStock samsung = new PersonalStock("Samsung", 70800.0);
		
		PersonalPortfolio john_portfolio = new PersonalPortfolio("John");
		john_portfolio.add(naver);
		john_portfolio.add(shinhan);
		
		PersonalPortfolio yujin_portfolio = new PersonalPortfolio("Yujin");
		yujin_portfolio.add(samsung);
		yujin_portfolio.add(shinhan);
		
		System.out.println("Total price of " + yujin_portfolio.getBuyer() + "'s portfolio is " + yujin_portfolio.getPrice() + " won.");
		System.out.println(yujin_portfolio.getBuyer() + "'s stocks are " + yujin_portfolio.getStockName() + "and that's it.");
		
		System.out.println("Total price of " + john_portfolio.getBuyer() + "'s portfolio is " + john_portfolio.getPrice() + " won.");
		System.out.println(john_portfolio.getBuyer() + "'s stocks are " + john_portfolio.getStockName() + "and that's it.");
		
	}
}
