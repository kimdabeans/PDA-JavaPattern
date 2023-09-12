package PageReplacement;

/**
 * Strategy Interface : 페이지 교체 알고리즘을 정의하는 인터페이스
 * @version 1.0
 * @author Park SangHee
 **/
public interface PageReplacementStrategy {
	/**
	 * 페이지를 교체하는 메서드
	 * @param demandPage 요구된 페이지의 교체할 번호
	 */
	public abstract void replace(int demandPage);
}
