package singleton_pattern;

/**
 * <p>
 * StaticBlock을 통해 예외를 처리하는 방식으로 Singleton Pattern을 구현한 클래스이다.
 * </p>
 * @author 서준원
 */
public class SingletonStaticBlock {

    private static SingletonStaticBlock instance;

    /**
     * 외부에서 인스턴스화를 방지하기 위해 생성자를 private으로 선언한다.
     */
    private SingletonStaticBlock() {}

    /**
     * 정적 블록을 사용하여 싱글톤 인스턴스를 초기화한다. <br>
     * 인스턴스 생성 중에 예외가 발생하면 예외가 catch되고 런타임 예외가 throw된다.
     * 
     * @throws : 인스턴스 생성 중 발생한 런타임 에러
     */
    static {
        try {
            instance = new SingletonStaticBlock();
        } catch (Exception e) {
            throw new RuntimeException("싱글톤 객체를 생성하는 중 오류 발생");
        }
    }

    /**
     * SingletonStaticBlock 클래스의 Instance를 가져오는 메서드.
     *
     * @return : static으로 선언해둔 Instance ( 생성한 SingletonStaticBlock 객체 )
     */
    public static SingletonStaticBlock getInstance() {
        return instance;
    }
}