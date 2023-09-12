package Factory_Method;

/**
 * description    : Pooh 인형을 생성하는 팩토리 클래스로 DollFactory 인터페이스를 구현하고 create메소드를 사용해 Pooh 인형 생성<br>
 * fileName       : PoohDollFactory<br>
 * author         : seoyun<br>
 * date           : 2023-09-09<br>

 */
public class PoohDollFactory implements DollFactory {
    /**
     *
     * @return PoohDoll 인스턴스
     */
    @Override
    public Doll create() {
        return new PoohDoll();
    }
}
