package visitor;
/**
 * <h3>File 클래스는 파일 엔트리를 나타내며, {@link Entry} 클래스를 확장합니다.</h3>
 *
 * @version 1.0.1
 * @author harin
 */
public class File extends Entry {
    /**
     * <p>파일의 이름.</p>
     */
    private String name;

    /**
     * <p>파일의 크기 (바이트).</p>
     */
    private int size;

    /**
     * <p>File 클래스의 생성자입니다.</p>
     *
     * @param name 파일의 이름
     * @param size 파일의 크기 (바이트)
     */
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * <p>파일의 이름을 반환합니다.</p>
     *
     * @return 파일의 이름
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <p>파일의 크기를 반환합니다.</p>
     *
     * @return 파일의 크기 (바이트)
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * <p>{@link Visitor}를 허용하고 해당 Visitor에게 자신을 방문하도록 합니다.</p>
     *
     * @param v Visitor 객체
     */
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}