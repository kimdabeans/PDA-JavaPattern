package Factory_Method;

/**
 * description    : Ryan 인형을 생성하는 팩토리 클래스로 DollFactory 인터페이스를 구현하고 create메소드를 사용해 Ryan 인형 생성<br>
 * fileName       : RyanDollFactory<br>
 * author         : seoyun<br>
 * date           : 2023-09-09<br>

 */
public class RyanDollFactory implements DollFactory {
    /**
     *
     * @return RyanDoll 인스턴스
     */
    @Override
    public Doll create() {
        return new RyanDoll();
    }
}
