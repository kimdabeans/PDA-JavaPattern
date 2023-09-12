package singleton_pattern;

/**
 * <p>
 * Lazy Initialization을 객체 생성에 대한 관리를 내부적으로 처리하는 방식으로 Singleton Pattern을 구현한 클래스이다.<br>
 * 메서드를 호출했을 때 인스턴스 변수의 null 유무에 따라 초기화 하거나 있는 걸 반환하는 기법이다.<br>
 * static 키워드로 인해 사용하지 않아도 고정적으로 메모리를 차지하는 문제 해결 가능하다.
 * </p>
 * @author 서준원
 */
public class SingletonLazy {

    private static SingletonLazy instance;

    /**
     * 외부에서 인스턴스화를 방지하기 위해 생성자를 private으로 선언한다.
     */
    private SingletonLazy() {}

    /**
     * Lazy Initialization을 활용해 Instance가 null 일 때만 SingletonLazy 객체를 생성한다. 
     *
     * @return : static으로 선언해둔 Instance ( 생성한 SingletonLazy 객체 )
     */
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy(); // 오직 하나의 객체만 생성합니다.
        }
        return instance;
    }
}

