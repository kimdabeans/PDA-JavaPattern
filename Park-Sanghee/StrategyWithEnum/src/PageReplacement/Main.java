package PageReplacement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main Class : 페이지 교체 알고리즘을 수행하는 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class Main {
	/**
	 * 프로그램의 주요 실행 메서드
	 * 사용자가 페이지 교체 알고리즘을 선택할 수 있게 하고, 입력된 페이지 교체
	 * @param args 명령행 인수 배열
	 * @throws IOException 입출력 예외 발생 시
	 **/
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// MemoryManager 객체 생성
		MemoryManager memoryManager = new MemoryManager();
		
		while (true) {
			System.out.println("사용할 페이지 교체 알고리즘을 선택해 주세요.");
			System.out.println("1. FIFO 알고리즘");
            System.out.println("2. LRU 알고리즘");
            System.out.println("3. LFU 알고리즘");
            System.out.println("4. 종료");
            System.out.print("선택 : ");
			
            // 사용자가 선택한 번호
			int strategyNum = Integer.parseInt(bf.readLine());
			
			// 종료 번호 선택 시 반복문 종료
			if (strategyNum == 4) {
				break;
			}
			else if (strategyNum < 1 || strategyNum > 3) {
				// 보기의 번호가 아닐 경우 다시 선택해달라는 메시지를 출력하고, 다시 선택 가능하도록 반복
				System.out.println("올바른 선택이 아닙니다. 다시 선택해 주세요.");
				System.out.println();
				continue;
			}
			
			// 교체할 페이지 번호
			System.out.print("교체할 페이지 : ");
			int demandPage = Integer.parseInt(bf.readLine());
			
			// 선택한 페이지 교체 알고리즘을 MemoryManager에 설정하고, 페이지 교체 수행
			PageReplacementAlgorithm pageReplacementAlgorithm = PageReplacementAlgorithm.values()[strategyNum - 1];
			memoryManager.setStrategy(pageReplacementAlgorithm.getPageReplacementStrategy());
			memoryManager.requestPageReplacement(demandPage);
			
			System.out.println();
		}
	}
}
