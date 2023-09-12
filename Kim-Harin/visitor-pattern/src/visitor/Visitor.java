package visitor;
/**
 * <h3>Visitor 클래스는 방문자 패턴을 구현하기 위한 추상 클래스로, {@link File} 및 {@link Directory}를 방문하는 메서드를 정의합니다.</h3>
 *
 * @version 1.0.1
 * @author harin
 */

public abstract class Visitor {
    /**
     *<p>File 엔트리를 방문하고 해당 동작을 구체적으로 정의하는 추상 메서드입니다.</p>
     *
     * @param file 방문할 File
     */
    public abstract void visit(File file);

    /**
     *<p>Directory 엔트리를 방문하고 해당 동작을 구체적으로 정의하는 추상 메서드입니다.</p>
     *
     * @param directory 방문할 Directory
     */
    public abstract void visit(Directory directory);
}