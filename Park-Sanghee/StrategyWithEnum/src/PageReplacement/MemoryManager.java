package PageReplacement;

/**
 * Context : 메모리 관리를 수행하는 클래스
 * @version 1.0
 * @author Park SangHee
 **/
public class MemoryManager {
	/**
	 * PageReplacementStrategy 인스턴스
	 **/
	private PageReplacementStrategy strategy;
	
	/**
	 * 기본 생성자
	 **/
	public MemoryManager() {
		
	}

	/**
	 * 페이지 교체 알고리즘을 사용하여 MemoryManager를 초기화하는 생성자
	 * @param strategy 페이지 교체 알고리즘 인스턴스
	 **/
	public MemoryManager(PageReplacementStrategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * 페이지 교체 알고리즘을 설정하는 메서드
	 * @param strategy 페이지 교체 알고리즘 인스턴스
	 **/
	public void setStrategy(PageReplacementStrategy strategy) {
        this.strategy = strategy;
    }

	/**
	 * 페이지 교체를 요구하는 메서드
	 * @param demandPage 요구된 페이지의 교체할 번호
	 **/
    public void requestPageReplacement(int demandPage) {
    	strategy.replace(demandPage);
    }
}
