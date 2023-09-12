package PageReplacement;

/**
 * ConcreteStrategy : LFU 페이지 교체 알고리즘을 구현하는 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class LFUStrategy implements PageReplacementStrategy {
	@Override
	public void replace(int demandPage) {
		System.out.println("LFU 교체 알고리즘을 사용하여 " + demandPage + " 페이지를 교체합니다.");
	}
}
