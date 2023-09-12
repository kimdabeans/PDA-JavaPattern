package Factory_Method;

/**
 * description    : DollFactory를 사용하여 다양한 인형을 생성하고 출력하는 Main클래스<br>
 * fileName       : Main<br>
 * author         : seoyun<br>
 * date           : 2023-09-09<br>
 */
public class Main {
    /**
     * 주어진 Factory를 사용해 인형을 생성하고 인형의 종류와 가격을 출력하는 메소드
     */
    public static void main(String[] args) {
        DollFactory PoohDollFactory = new PoohDollFactory();
        DollFactory MickeyDollFactory = new MickeyDollFactory();
        DollFactory RyanDollFactory = new RyanDollFactory();
        Doll PoohDoll  = PoohDollFactory.create();
        Doll MickeyDoll  = MickeyDollFactory.create();
        Doll RyanDoll = RyanDollFactory.create();

        PoohDoll.print();
        MickeyDoll.print();
        RyanDoll.print();
    }
}