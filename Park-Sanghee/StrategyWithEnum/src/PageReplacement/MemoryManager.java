package PageReplacement;

public class MemoryManager {
	private PageReplacementStrategy strategy;
	
	public MemoryManager() {
		
	}
	
	public MemoryManager(PageReplacementStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void setStrategy(PageReplacementStrategy strategy) {
        this.strategy = strategy;
    }

    public void requestPageReplacement(int demandPage) {
    	strategy.replace(demandPage);
    }
}
