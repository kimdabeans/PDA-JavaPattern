package observer;
/**
 * 클라이언트에게 알림 메시지를 전송하는 클래스.
 */
public class NotifyClient implements Notify {
	// 너비 상수
	private static final int WIDTH = 31;
	
	 @Override
	 public void sendMessage(Client client, String message) {
		 printHeader();
		 printEmail(client.getEmail());
	     printMessage(message);
	     printFooter();
	 }
	 
	 /**
	  * 알림 메시지의 헤더 부분 출력.
	  */
	 private void printHeader() {
		 printLine(WIDTH);
	     System.out.println("|\t     Message   \t\t|");
	     printLine(WIDTH);
	 }
	 
	 /**
	  * 클라이언트의 이메일 출력.
	  *
	  * @param email 클라이언트의 이메일 주소.
	  */
	 private void printEmail(String email) {
		 System.out.println("|  To. " + email + " \t\t|");
	     printLine(WIDTH);
	 }
	 
	 /**
	  * 알림의 메인 메시지 출력.
	  *
	  * @param message 알림 메시지.
	  */
	 private void printMessage(String message) {
		 System.out.println("|  [Web발신] 주가 변동 알림 \t\t|");
		 System.out.println("|  " + message + "|");
	     printLine(WIDTH);
	 }
	 
	 /**
	  * 알림 메시지의 푸터 부분 출력.
	  */
	 private void printFooter() {
		 System.out.println("|  From. Admin   \t\t|");
	     printLine(WIDTH);
	 }
	 
	 /**
      * 주어진 너비만큼의 구분선 출력.
      *
      * @param width 구분선의 너비.
      */
	 private void printLine(int width) {
		 System.out.print("+");
         for (int i=0; i<width; i++) {
        	 System.out.print("-");
         }
         System.out.println("+");
     }
}