/**
 * Cache 사례를 테스트하기 위해서 구현한 User 클래스입니다.
 */
public class User {
	/**
	 * User의 name 변수입니다.
	 */
    private String name;

    /**
     * User 클래스의 생성자로, User의 name을 설정합니다.
     * 
     * @param name
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * User의 name을 반환합니다.
     * 
     * @return User의 name을 리턴합니다.
     */
    public String getName() {
        return name;
    }
}