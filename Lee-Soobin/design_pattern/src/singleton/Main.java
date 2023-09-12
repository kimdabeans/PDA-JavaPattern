package singleton;

/**
 * Singleton 패턴을 테스트하는 메인 클래스.
 */
public class Main {

    /**
     * 메인 생성자.
     */
    public Main(){
    }

    /**
     * 프로그램의 진입점.
     * @param args 명령행 인수
     */
    public static void main(String[] args){
        System.out.println("Start");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2){
            System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
        }
        System.out.println("End");
    }
}