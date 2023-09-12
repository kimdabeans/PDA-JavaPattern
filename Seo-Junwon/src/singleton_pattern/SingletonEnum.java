package singleton_pattern;

/**
 * 열거형(enum)을 사용하여 Singleton Pattern을 구현한 클래스
 * Java를 활용한 Singleton Pattern에서 가장 간단하고 안전한 방법 중 하나이다.
 * 
 * @author 서준원
 */
enum SingletonEnum {
    
    /**
     * SingletonEnum의 인스턴스를 나타낸다.
     */
    INSTANCE;

    private String dbClient = "dbClient";
	
    /**
     * SingletonEnum의 생성자로 dbClient 변수를 초기화한다.
     */
    SingletonEnum() {
        dbClient = dbClient.toString();
    }

    /**
     * SingletonEnum의 인스턴스를 가져온다.
     *
     * @return : SingletonEnum 객체의 인스턴스
     */
    public static SingletonEnum getInstance() {
        return INSTANCE;
    }

    /**
     * 현재 SingletonEnum 인스턴스의 클라이언트 정보를 반환한다.
     *
     * @return : 클라이언트 정보의 내용
     */
    public String getClient() {
        return dbClient;
    }
}

