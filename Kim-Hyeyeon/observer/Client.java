package observer;
/**
 * 주가 변동 시 알림을 받는 클라이언트에 대한 클래스.
 */
public class Client {
private String name;
private String email;
/**
 * 고객의 이름과 이메일로 초기화.
 * @param name  고객의 이름
 * @param email 고객의 이메일 주소
 */
public Client(String name, String email) {
   this.name = name;
   this.email = email;
}

public String getEmail() {
   return email;
}

public String getName() {
   return name;
}
}
