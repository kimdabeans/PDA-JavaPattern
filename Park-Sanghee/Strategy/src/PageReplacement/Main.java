package PageReplacement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PageReplacementStrategy fifoStrategy = new FIFOStrategy();
		PageReplacementStrategy lruStrategy = new LRUStrategy();
		PageReplacementStrategy lfuStrategy = new LFUStrategy();
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
				memoryManager.setStrategy(fifoStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 2) {
				System.out.print("교체할 페이지 : ");
				int demandPage = Integer.parseInt(bf.readLine());
				memoryManager.setStrategy(lruStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 3) {
				System.out.print("교체할 페이지 : ");
				int demandPage = Integer.parseInt(bf.readLine());
				memoryManager.setStrategy(lfuStrategy);
				memoryManager.requestPageReplacement(demandPage);
			}
			else if (strategyNum == 4) {
				break;
			}
			else {
				System.out.println("올바른 선택이 아닙니다. 다시 선택해 주세요.");
			}
			
			System.out.println();
		}
	}
}
