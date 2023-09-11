package composite;

public class ResarchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonalStock shinhan = new PersonalStock("Shinhan", 2800.0);
		PersonalStock naver = new PersonalStock("Naver", 3400.0);
		PersonalStock samsung = new PersonalStock("Samsung", 5400.0);
		
		PersonalPortfolio john_portfolio = new PersonalPortfolio("John");
		john_portfolio.add(naver);
		john_portfolio.add(shinhan);
		
		PersonalPortfolio yujin_portfolio = new PersonalPortfolio("Yujin");
		yujin_portfolio.add(samsung);
		yujin_portfolio.add(shinhan);
		
		System.out.println("Total price of " + yujin_portfolio.name() + "'s portfolio is " + yujin_portfolio.price());
		System.out.println("Total price of " + john_portfolio.name() + "'s portfolio is " + john_portfolio.price());
	}
}
