package BeforeProxy;


/**
 * 프린터를 나타내는 클래스입니다.
 */
public class Printer implements Printable {
	
	private String name;
	
	/**
	 * 기본 생성자로, 프린터를 생성하면서 초기화 작업을 수행합니다.
	 * 
	 * <p>인스턴스 생성 시마다 무거운 작업으로 가정된 동작이 수반됩니다.</p>
	 */
	public Printer() {
		heavyjob("On Production an instance");
	}
	
	/**
	 * 주어진 이름으로 프린터를 생성합니다.
	 * 
	 * @param name 프린터의 이름
	 */
	public Printer(String name) {
		this.name = name;
	}

	/**
	 * 주어진 이름으로 프린터를 생성합니다.
	 *
	 * @param name 프린터의 이름
	 */
	@Override
	public void setPrinterName(String name) {
		this.name = name;
	}

	/**
	 * 주어진 문자열로 프린터의 이름을 설정합니다.
	 *
	 * @param name 프록시의 이름
	 */
	@Override
	public void getPrinterName() {
		System.out.println("The current name is \"" + this.name + "\"");
	}

	/**
	 * 현재 프린터의 이름을 알려줍니다.
	 * 	 
	 * @param name 프록시의 이름
	 */
	@Override
	public void print(String string) {
		System.out.println("===" + name + "===");
		System.out.println(string);
	}
	
	/**
	 * 무거운 작업이라고 가정된 동작입니다.
	 * 
	 * <p>동작하기까지 5초의 시간이 소요됩니다. 인스턴스 생성 시 항상 수반된다. </p>
	 *
	 * @param name 프린터의 이름
	 */
	private void heavyjob(String msg) {
		System.out.println(msg);
		for(int i=0; i<5; i++) {
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
			}
			System.out.println(".");
		}
		System.out.println("done");
	}
}
