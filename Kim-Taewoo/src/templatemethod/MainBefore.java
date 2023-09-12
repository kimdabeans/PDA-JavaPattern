package templatemethod;

public class MainBefore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShinRamenBefore shinramen = new ShinRamenBefore();
		JinRamenBefore jinramen = new JinRamenBefore();
		SesameRamenBefore sesameramen = new SesameRamenBefore();
		ShinRamenBlackBefore shinramenblack = new ShinRamenBlackBefore();
		
		shinramen.makeShinRamen();
		jinramen.makeJinRamen();
		sesameramen.makeSesameRamen();
		shinramenblack.makeShinRamenBlack();
	}

}
