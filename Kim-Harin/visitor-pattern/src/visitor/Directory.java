package visitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * <h3>Directory 클래스는 디렉토리 엔트리를 나타내며, {@link Iterable} 인터페이스를 구현합니다.</h3>
 */
public class Directory extends Entry implements Iterable<Entry> {
    /**
     * <p>디렉토리의 이름.</p>
     */
    private String name;

    /**
     * <p>디렉토리 내의 엔트리 목록.</p>
     */
    private List<Entry> directory = new ArrayList<>();

    /**
     * <p>Directory 클래스의 생성자입니다.</p>
     *
     * @param name 디렉토리의 이름
     */
    public Directory(String name) {
        this.name = name;
    }

    /**
     * <p>디렉토리의 이름을 반환합니다.</p>
     *
     * @return 디렉토리의 이름
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <p>디렉토리 내의 모든 엔트리의 크기를 합산하여 반환합니다.</p>
     *
     * @return 디렉토리의 크기 (바이트)
     */
    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

    /**
     * <p>디렉토리에 새로운 엔트리를 추가하고 자신을 반환합니다.</p>
     *
     * @param entry 추가할 엔트리
     * @return 자신의 참조를 반환
     */
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    /**
     * <p>디렉토리 내의 엔트리들을 순환하기 위한 반복자를 반환합니다.</p>
     *
     * @return 디렉토리 엔트리들을 순환하는 반복자
     */
    @Override
    public Iterator<Entry> iterator() {
        return directory.iterator();
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