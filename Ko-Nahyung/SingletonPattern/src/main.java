/**
 * Cache 클래스를 테스트하기 위해서 구현한 main 클래스
 */
public class main {

	 public static void main(String[] args) {
	        Cache cache = Cache.getInstance();

	        // 캐시에 데이터 추가
	        cache.put("user1", new User("Bob"));
	        cache.put("user2", new User("Alice"));

	        // 캐시에서 데이터 검색
	        User user1 = (User) cache.get("user1");
	        User user2 = (User) cache.get("user2");

	        if (user1 != null) {
	            System.out.println("User1 found: " + user1.getName());
	        }

	        if (user2 != null) {
	            System.out.println("User2 found: " + user2.getName());
	        }

	        // 캐시에서 데이터 삭제
	        cache.remove("user1");

	        // 캐시에 없는 데이터 검색
	        User user1Again = (User) cache.get("user1");

	        if (user1Again == null) {
	            System.out.println("User1 not found in cache.");
	        }
	    }

}
