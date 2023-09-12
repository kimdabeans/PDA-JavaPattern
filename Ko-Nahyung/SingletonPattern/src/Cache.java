import java.util.HashMap;
import java.util.Map;

/**
 * Singleton Pattern을 활용하여 구현한 Cache 클래스
 */
public class Cache {
	/**
	 * cache값을 저장하기 위한 cacheMap 변수입니다.
	 */
    private Map<String, Object> cacheMap;

    /**
     * Cache 클래스의 생성자로, cacheMap을 할당합니다.
     */
    private Cache() {
        cacheMap = new HashMap<>();
    }

    /**
     * Cache 클래스 내부에 선언된 private static LazyHolder 클래스입니다.
     * 해당 클래스를 통해서 Cache 인스턴스를 final로 선언하고 생성합니다.
     */
    private static class LazyHolder {
        private static final Cache INSTANCE = new Cache();
    }
    
	/**
	 * Cache 클래스의 인스턴스를 반환합니다.
	 * 
	 * @return LazyHolder의 Cache를 참조하여 반환합니다.
	 */
    public static Cache getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * cacheMap에 key값과 value값을 데이터로 저장합니다.
     * 
     * @param key 저장하고자 하는 key값
     * @param value 저장하고자 하는 value값
     */
    public void put(String key, Object value) {
        cacheMap.put(key, value);
    }

	/**
	 * cacheMap에서 key값으로 찾은 Object를 반환합니다.
	 * 
	 * @param key 얻고자하는 key값
	 * @return cacheMap에서 key값으로 찾은 Object를 리턴합니다.
	 */
    public Object get(String key) {
        return cacheMap.get(key);
    }

	/**
	 * cacheMap에서 key값으로 찾은 결과를 반환합니다.
	 * 
	 * @param key 찾고자하는 key값
	 * @return cacheMap에서 key값으로 찾고, key값을 갖는 Object가 존재하면 true, 존재하지 않으면 false를 리턴합니다.
	 */
    public boolean containsKey(String key) {
        return cacheMap.containsKey(key);
    }

	/**
	 * cacheMap에서 key값으로 찾은 Object를 삭제합니다.
	 * 
	 * @param key 삭제하고자 하는 key값
	 */
    public void remove(String key) {
        cacheMap.remove(key);
    }
}
