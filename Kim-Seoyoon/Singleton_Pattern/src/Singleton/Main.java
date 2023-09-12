package Singleton;

/**
 * description    : Singleton의 주요 목적인 유일한 인스턴스가 생성되는지 여부를 확인할 수 있는 Main클래스<br>
 * packageName    : Singleton<br>
 * fileName       : Main<br>
 * author         : seoyun<br>
 * date           : 2023-09-11<br>
 */
public class Main {
    public static void main(String[] args) {

        // Singleton.getInstance() 를 통해 싱글톤 객체를 서로 다른 변수에서 생성해도 똑같은 객체 주소를 가리킴
        Singleton i1 = Singleton.getInstance();
        Singleton i2 = Singleton.getInstance();
        Singleton i3 = Singleton.getInstance();

        // 유일한 인스턴스 이므로 출력값이 동일
        System.out.println(i1.toString());
        System.out.println(i2.toString());
        System.out.println(i3.toString());

        // 하나의 인스턴스 이므로 true출력값 반환
        System.out.println(i1 == i2);
    }
}


