package visitor;
/**
 * <h3> Main 클래스는 주어진 예제 코드를 실행하는 메인 클래스입니다. </h3>
 *
 * @version 1.0.1
 * @author harin
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrdir = new Directory("usr");
        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);
        bindir.add(new File("vi", 10000));
        bindir.add(new File("latex", 20000));
        rootdir.accept(new ListVisitor());
        System.out.println();

        System.out.println("Making user entries...");
        Directory harin = new Directory("harin");
        Directory shinhan = new Directory("shinhan");
        Directory prodigital = new Directory("prodigital");
        usrdir.add(harin);
        usrdir.add(shinhan);
        usrdir.add(prodigital);
        harin.add(new File("diary.html", 100));
        harin.add(new File("Composite.java", 200));
        shinhan.add(new File("memo.tex", 300));
        prodigital.add(new File("game.doc", 400));
        prodigital.add(new File("junk.mail", 500));
        rootdir.accept(new ListVisitor());
    }
}