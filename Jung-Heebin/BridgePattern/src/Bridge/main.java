package Bridge;

/**
 * main 클래스는 Bridge 패턴을 사용하여 Display를 생성하고 사용하는 예시를 제공합니다.
 */
public class main {

	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("This is Display1"));
		Display d2 = new Display(new StringDisplayImpl("This is Display2"));
		
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("This is CountDisplay"));
		StringDisplayImpl d4 = new StringDisplayImpl("This is StringDisplayImpl");
		
		
		d1.display();
		d2.display();
	
		d3.display();
		d3.multiDisplay(5);
		
		d4.rawClose();
		d4.rawPrint();
		d4.rawClose();
	}

}
