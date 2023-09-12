package visitor;
/**
 * <h3>Entry 클래스는 {@link Element}를 구현하는 추상 클래스로, 엔트리(파일 또는 디렉토리)의 공통 동작을 정의합니다.</h3>
 *
 */
public abstract class Entry implements Element {
    /**
     * <p>엔트리의 이름을 얻습니다.</p>
     *
     * @return 엔트리의 이름
     */
    public abstract String getName();

    /**
     * <p>엔트리의 크기를 얻습니다.</p>
     *
     * @return 엔트리의 크기 (바이트)
     */
    public abstract int getSize();

    /**
     * <p>엔트리를 문자열로 표현합니다.</p>
     *
     * @return 엔트리의 이름과 크기를 포함한 문자열
     */
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}