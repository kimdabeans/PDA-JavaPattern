package Factory_Method;

/**
 * description    : Mickey Mouse 인형을 생성하는 팩토리 클래스로 DollFactory 인터페이스를 구현하고 create메소드를 사용해 Mickey Mouse 인형 생성<br>
 * fileName       : MickeyDollFactory<br>
 * author         : seoyun<br>
 * date           : 2023-09-09<br>
 */
public class MickeyDollFactory implements DollFactory {
    /**
     *
     * @return MickeyDoll 인스턴스
     */
    @Override
    public Doll create() {
        return new MickeyDoll();
    }
}
