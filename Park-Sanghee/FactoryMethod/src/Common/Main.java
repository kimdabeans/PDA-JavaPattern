package Common;

import Factory.Factory;
import Factory.Doll;
import Doll.TeddyBearFactory;

/**
 * Main Class : 곰인형을 만들고 관련된 기능을 수행하는 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class Main {
	/**
	 * 프로그램의 주요 실행 메서드
	 * 곰인형을 만들고, 인형의 이름을 출력
	 * @param args 명령행 인수 배열
	 **/
	public static void main(String[] args) {
		// 곰인형 공장 생성
		Factory teddyBearFactory = new TeddyBearFactory();
		
		// 곰인형 'Teddy' 생성하고 이름 출력
		Doll bearTeddy = teddyBearFactory.create("Bear", "Teddy");
		bearTeddy.getName();
		
		System.out.println();

		// 곰인형 'Lebby' 생성하고 이름 출력
		Doll bearLebby = teddyBearFactory.create("Bear", "Lebby");		
		bearLebby.getName();
	}
}
