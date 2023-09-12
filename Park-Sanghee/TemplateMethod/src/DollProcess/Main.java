package DollProcess;

public class Main {
	public static void main(String[] args) {
		DollProcess rabbitDoll = new RabbitDollProcess("Rabbit");
		DollProcess catDoll = new CatDollProcess("Cat");
		
		rabbitDoll.createDoll();
		System.out.println();
		catDoll.createDoll();
	}
}
