package factorymethod;

public class MainBefore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShinRamenFactoryBefore shinramenfactory = new ShinRamenFactoryBefore();
		SesameRamenFactoryBefore sesameramenfactory = new SesameRamenFactoryBefore();
		
		ShinRamenBefore shinramen = shinramenfactory.createShinRamen();
		SesameRamenBefore sesameramen = sesameramenfactory.createSesameRamen();
		
		shinramen.packaging();
		shinramen.deliver();
		sesameramen.packaging();
		sesameramen.deliver();
	}

}
