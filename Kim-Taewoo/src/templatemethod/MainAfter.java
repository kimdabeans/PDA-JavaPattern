package templatemethod;

public class MainAfter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ramen shinramen = new ShinRamenAfter();
		Ramen jinramen = new JinRamenAfter();
		Ramen sesameramen = new SesameRamenAfter();
		Ramen shinramenblack = new ShinRamenBlackAfter();
		
		shinramen.RamenLogic();
		jinramen.RamenLogic();
		sesameramen.RamenLogic();
		shinramenblack.RamenLogic();
	}

}
