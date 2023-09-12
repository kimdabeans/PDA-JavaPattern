package DollProcess;

/**
 * Main Class : 인형을 만드는 과정을 수행하는 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class Main {
	/**
	 * 프로그램의 주요 실행 메서드
	 * 토끼 인형과 고양이 인형을 만드는 과정 수행
	 * @param args 명령행 인수 배열
	 **/
	public static void main(String[] args) {
		DollProcess rabbitDoll = new RabbitDollProcess("Rabbit");
		DollProcess catDoll = new CatDollProcess("Cat");
		
		// 토끼 인형 만들기
		rabbitDoll.createDoll();
		
		System.out.println();
		
		// 고양이 인형 만들기
		catDoll.createDoll();
	}
}
