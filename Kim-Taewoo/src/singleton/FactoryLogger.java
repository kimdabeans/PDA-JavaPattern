package singleton;

/**
 * 공장의 생산기록을 관리하는 클래스 
 */
public class FactoryLogger {
	/**
	 * 하나만 존재하는 공장 생산기록 객체 
	 */
	private static FactoryLogger logger;
	/**
	 * 공통관리를 위한 로그 
	 */
	private static String logs;
	/**
	 * 공장 생산기록 클래스 생성자 
	 */
	private FactoryLogger() {
		logs = "<공장 생산 기록>\n";
	}
	/**
	 * 공장 생산기록 인스턴스를 반환하는 메서드 
	 * @return 공장 생산기록 인스턴스 
	 */
	public static FactoryLogger getInstance() {
		if (logger == null) {
			logger = new FactoryLogger();
		}
		return logger;
	}
	/**
	 * 생산 기록 추가하기 
	 * @param log 추가 할 기록 
	 */
	public void addLog(String log) {
		logs += (log + "\n");
	}
	/**
	 * 생산 기록 받기 
	 * @return 저장된 생산기록 반환 
	 */
	public static String getLog() {
		return logs;
	}
}
