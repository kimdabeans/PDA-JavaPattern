package Factory_Method;

/**
 * description    : Factory Method Pattern에서 프레임워크 쪽으로 Doll 추상클래스를 생성하는 인터페이스<br>
 * fileName       : DollFactory<br>
 * author         : seoyun<br>
 * date           : 2023-09-09<br>
 */


public interface DollFactory {
    /**
     * 인형의 종류에 맞는 생성자 생성하는 메소드
     * @return Doll 인스턴스 반환
     */
    Doll create();
}
