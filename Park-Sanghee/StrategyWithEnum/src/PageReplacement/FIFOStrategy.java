package PageReplacement;

public class FIFOStrategy implements PageReplacementStrategy {
	@Override
	public void replace(int demandPage) {
		System.out.println("FIFO 교체 알고리즘을 사용하여 " + demandPage + " 페이지를 교체합니다.");
	}
}
