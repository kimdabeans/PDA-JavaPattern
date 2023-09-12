package PageReplacement;

public enum PageReplacementAlgorithm {
	FIFO(new FIFOStrategy()),
	LRU(new LRUStrategy()),
	LFU(new LFUStrategy());
	
	private final PageReplacementStrategy strategy;
	
	PageReplacementAlgorithm(PageReplacementStrategy strategy) {
		this.strategy = strategy;
	}
	
	public PageReplacementStrategy getPageReplacementStrategy() {
		return strategy;
	}
}
