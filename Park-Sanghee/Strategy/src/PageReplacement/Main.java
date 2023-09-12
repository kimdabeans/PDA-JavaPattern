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
		
		// 페이지 교체 알고리즘 객체 생성
		PageReplacementStrategy fifoStrategy = new FIFOStrategy();
		PageReplacementStrategy lruStrategy = new LRUStrategy();
		PageReplacementStrategy lfuStrategy = new LFUStrategy();
		
		// MemoryManager 객체 생성
		MemoryManager memoryManager = new MemoryManager();
		
		while (true) {
			System.out.println("사용할 페이지 교체 알고리즘을 선택해 주세요.");
			System.out.println("1. FIFO 알고리즘");
            System.out.println("2. LRU 알고리즘");
            System.out.println("3. LFU 알고리즘");
            System.out.println("4. 종료");
            System.out.print("선택 : ");
			
			int strategyNum = Integer.parseInt(bf.readLine());
			if (strategyNum == 1) {
				System.out.print("교체할 페이지 : ");
				int demandPage = Integer.parseInt(bf.readLine());
				
				// FIFO 페이지 교체 알고리즘을 사용하여 페이지 교체 요구
				memoryManager.setStrategy(fifoStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 2) {
				System.out.print("교체할 페이지 : ");
				int demandPage = Integer.parseInt(bf.readLine());
				
				// LRU 페이지 교체 알고리즘을 사용하여 페이지 교체 요구
				memoryManager.setStrategy(lruStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 3) {
				System.out.print("교체할 페이지 : ");
				int demandPage = Integer.parseInt(bf.readLine());
				
				// LFU 페이지 교체 알고리즘을 사용하여 페이지 교체 요구
				memoryManager.setStrategy(lfuStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 4) {
				// 프로그램 종료
				break;
			}
			else {
				System.out.println("올바른 선택이 아닙니다. 다시 선택해 주세요.");
			}
			
			System.out.println();
		}
	}
}
