# Singleton Pattern

&ensp;Singleton은 클래스에 인스턴스가 하나만 있도록 하면서 이 인스턴스에 대한 전역 접근(액세스) 지점을 제공하는 생성 디자인 패턴입니다.
일반적인 Singlton 패턴의 UML은 다음과 같습니다.
### General Singleton Pattern UML

![Singleton_general](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/81a25f42-3847-4e78-b4f1-49c85f8cb6d2)
&ensp;Singleton 클래스의 특징은 다음과 같습니다.
- default 생성자를 private으로 선언
- 생성자 역할을 하는 정적 생성 메서드( getInstance() ) 구현
- 정적 생성 메서드를 통해서, private 생성자를 호출한 후 객체를 정적 필드에 저장
- 초기 호출 이후의 모든 호출들은 모두 캐시된 객체를 반환


## 다양한 종류의 Singleton Pattern
### Case A: 교재에 소개된 Singleton Pattern
-- 교재에 소개된 방식으로 구현된 Singleton 패턴입니다. 클래스가 인스턴스를 사용하지 않는 경우에도, 가지고 있기 때문에 자원낭비가 발생합니다.
```java
/**
 * 교재에 소개된 방식으로 구현한 Singleton 패턴입니다.
 */
public class SingletonA {
	/**
	 * SingletonA 클래스의 인스턴스를 나타내는 정적 변수입니다.
	 */
	private static SingletonA singletonA = new SingletonA();
	
	/**
	 * SingletonA 클래스의 생성자로, 생성되었음을 콘솔에 출력합니다.
	 * private 생성자로, Singleton Pattern의 특징을 갖습니다.
	 */
	private SingletonA() {
		System.out.println("Singleton A 인스턴스를 생성했습니다.");
	}
	
	/**
	 * SingletonA 클래스의 인스턴스를 반환합니다.
	 * 
	 * @return 기존에 생성되어있던 singletonA 인스턴스를 반환합니다.
	 */
	public static SingletonA getInstance() {
		return singletonA;
	}
}
```
### Case B: 자원낭비를 보완한 Singleton Pattern
-- 자원낭비를 보완한 Singleton 패턴입니다. 하지만 멀티 스레드 환경에서 의도와 달리 2개 이상의 인스턴스가 생성될 위험이 존재합니다.
```java
/**
 * SingletonA 클래스에서 자원 낭비가 발생하는 단점을 보완한 Singleton 패턴입니다.
 */
public class SingletonB {
	/**
	 * SingletonB 클래스의 인스턴스를 나타내는 정적 변수입니다.
	 */
	private static SingletonB singletonB;
	
	/**
	 * SingletonB 클래스의 생성자로, 생성되었음을 콘솔에 출력합니다.
	 * private 생성자로, Singleton Pattern의 특징을 갖습니다.
	 */
	private SingletonB() {
		System.out.println("Singleton B 인스턴스를 생성했습니다.");
	}
	
	/**
	 * SingletonB 클래스의 인스턴스를 반환합니다.
	 * 
	 * @return 기존에 생성되어있던 SingletonB 인스턴스 또는 새롭게 생성한 인스턴스를 반환합니다.
	 */
	public static SingletonB getInstance() {
		if (singletonB == null) {
			singletonB = new SingletonB();
		}
	    return singletonB; 
	}
}
```
### Case C: synchronized를 적용한 Singleton Pattern
-- synchronized를 통해서 멀티 스레드 환경에서 2개 이상의 인스턴스가 생성될 위험을 제거했습니다. 하지만, 이 경우 synchronized로 인해서 성능 저하가 발생하게 됩니다.
```java
/**
 * SingletonB 클래스에서 멀티스레드 환경 동작을 고려한 Singleton 패턴입니다.
 */
public class SingletonC {
	/**
	 * SingletonC 클래스의 인스턴스를 나타내는 정적 변수입니다.
	 */
    private static SingletonC singletonC;

	/**
	 * SingletonC 클래스의 생성자로, 생성되었음을 콘솔에 출력합니다.
	 * private 생성자로, Singleton Pattern의 특징을 갖습니다.
	 */
    private SingletonC() {
    	System.out.println("Singleton C 인스턴스를 생성했습니다.");
    }

	/**
	 * SingletonC 클래스의 인스턴스를 반환합니다.
	 * synchronized를 통해 멀티스레드 환경에서 동작 시, 2개 이상의 인스턴스가 생성되는 것을 방지합니다.
	 * 
	 * @return 기존에 생성되어있던 SingletonC 인스턴스 또는 새롭게 생성한 인스턴스를 반환합니다.
	 */
    public static synchronized SingletonC getInstance() {
        if (singletonC == null) {
        	singletonC = new SingletonC();
        }
        return singletonC;
    }
}

```
### Case D: LazyHolder로 개선한 Singleton Pattern
#### UML
![Singleton_LazyHolder](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/ae04d850-986b-41a4-9dfd-509a6a057820)


-- private static class인 LazyHolder 내에서, instance를 final로 선언하는 방법입니다. 해당 클래스는 Singleton 클래스가 Load 될 때에 Load 되지 않다가 getInstance()가 호출되어야 JVM 메모리에 로드되고, 인스턴스를 생성하게 됩니다. 인스턴스를 final로 선언했기 때문에 다시 instance가 할당되는 것 또한 막을 수 있습니다.


&ensp; 즉, LazyHolder.singlton을 참조하는 순간 Class가 로딩되며 초기화가 진행됩니다. Class를 로딩하고 초기화하는 시점은 thread-safe를 보장하므로 앞선 방식의 synchronized를 사용하지 않아도 됩니다.


&ensp;이와같이 synchronized를 사용하지 않더라도, JVM 자체가 보장하는 원자성을 사용하여 thread-safe 하게 Singleton 패턴을 구현할 수 있습니다. 해당 방식은 자바 버전에도 상관없는 방법입니다.

```java
/**
 * SingletonC 클래스에서 synchronized를 통한 성능 저하를 고려한 Singleton 패턴입니다.
 */
public class SingletonD {
	
	/**
	 * SingletonD 클래스의 생성자로, 생성되었음을 콘솔에 출력합니다.
	 * private 생성자로, Singleton Pattern의 특징을 갖습니다.
	 */
    private SingletonD() {
    	System.out.println("Singleton D 인스턴스를 생성했습니다.");
    }
    
    /**
     * SingletonD 클래스 내부에 선언된 private static LazyHolder 클래스입니다.
     * 해당 클래스를 통해서 singletonD 인스턴스를 final로 선언하고 생성합니다.
     */
    private static class LazyHolder {
        private static final SingletonD singletonD = new SingletonD();
    }
    
	/**
	 * SingletonD 클래스의 인스턴스를 반환합니다.
	 * 
	 * @return LazyHolder의 singletonD를 참조하여 반환합니다.
	 */
    public static SingletonD getInstance() {
        return LazyHolder.singletonD;
    }
}
```
### Case E: Singleton Pattern을 Cache에 적용해보기
--- Case D의 LazyHolder로 개선한 Singleton Pattern을 이용해서, Cache 동작을 구현해보았습니다.
#### UML
![Singleton_Cache](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/5d7373b2-0ea7-40fd-8122-45371fc2d64a)

#### Code
```java
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
```
```java
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
```
```java
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
```
#### 실행결과
![singleton_result](https://github.com/kimdabeans/PDA-JavaPattern/assets/45055301/50f2ab67-5428-47ba-8a85-df350bcaf2c8)

