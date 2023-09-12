package visitor;
/**
 * <h3>ListVisitor 클래스는 {@link Visitor}의 구체적인 구현체로, 디렉토리 내의 엔트리를 나열합니다.</h3>
 *
 */
public class ListVisitor extends Visitor {
    /**
     * <p>현재 주목하는 디렉토리 이름.</p>
     */
    private String currentdir = "";

    /**
     * <p>File 엔트리를 방문하면 해당 파일의 이름을 현재 디렉토리 경로와 함께 출력합니다.</p>
     *
     * @param file 방문할 File
     */
    @Override
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    /**
     *
     * <p>Directory 엔트리를 방문하면 해당 디렉토리의 이름을 현재 디렉토리 경로와 함께 출력하고,</p>
     * <p>디렉토리 내의 엔트리들을 순환하며 방문합니다.</p>
     *
     * @param directory 방문할 Directory 엔트리
     */
    @Override
    public void visit(Directory directory) {
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        for (Entry entry: directory) {
            entry.accept(this);
        }
        currentdir = savedir;
    }
}