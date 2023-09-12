package visitor;
/**
 * <h3>Element 인터페이스는 방문자 패턴을 구현하기 위한 인터페이스로, {@link Visitor}를 허용하기 위한 메서드를 정의합니다.</h3>
 *
 */
public interface Element {
    /**
     * <p>Visitor 객체를 허용하고 방문자 패턴을 구현하기 위해 필요한 동작을 수행합니다.</p>
     *
     * @param v Visitor 객체
     */
    void accept(Visitor v);
}
