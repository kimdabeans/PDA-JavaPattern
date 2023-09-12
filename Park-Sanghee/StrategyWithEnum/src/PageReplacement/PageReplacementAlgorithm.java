package PageReplacement;

/**
 * 페이지 교체 알고리즘을 나타내는 Enum
 * @version 1.0
 * @author Park SangHee
 **/
public enum PageReplacementAlgorithm {
	FIFO(new FIFOStrategy()),
	LRU(new LRUStrategy()),
	LFU(new LFUStrategy());
	
	/**
	 * PageReplacementStrategy 인스턴스
	 **/
	private final PageReplacementStrategy strategy;

	/**
	 * PageReplacementAlgorithm의 생성자
	 * @param strategy 해당 페이지 교체 알고리즘을 나타내는 페이지 교체 알고리즘 인스턴스
	 **/
	PageReplacementAlgorithm(PageReplacementStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 해당 페이지 교체 알고리즘의 페이지 교체 알고리즘을 반환하는 메서드
	 * @return 페이지 교체 알고리즘 인스턴스
	 **/
	public PageReplacementStrategy getPageReplacementStrategy() {
		return strategy;
	}
}
