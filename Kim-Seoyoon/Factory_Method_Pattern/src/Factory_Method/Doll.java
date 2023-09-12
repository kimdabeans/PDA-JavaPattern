package Factory_Method;

/**
 * 큰 정수를 처리하기 위한 클래스 BinInteger을 사용하기 위해 정의한 import문
 */
import java.math.BigInteger;


/**
 * description    : Factory Method Pattern에서 프레임워크에 속하는 Doll 추상 클래스로 하위 클래스에서 Doll에 대한 구체적인 내용 정의<br>
 * fileName       : Doll<br>
 * author         : seoyun<br>
 * date           : 2023-09-09<br>
 */
public abstract class Doll {
    /**
     * 인형의 가격을 나타내기 위한 price변수 선언
     */
    protected BigInteger price;
    /**
     * 인형의 종류를 나타내기 위한 type변수 선언
     */
    protected DollType type;

    /**
     * 인형의 종류와 가격을 나타내는 print메소드
     */
    public void print() {
        System.out.println("이것은 "+type.getName()+"인형이고 가격은 "+price+"이다.");
    }
}

/**
 * Doll을 상속받는 하위 클래스로 Doll에 대한 구체적인 종류를 나타내는 클래스
 */
class PoohDoll extends Doll {

    /**
     * Pooh 인형의 가격과 Pooh type정의
     */
    protected PoohDoll() {
        this.price = new BigInteger("20000");
        this.type = DollType.Pooh;
    }
}

/**
 * Doll을 상속받는 하위 클래스로 Doll에 대한 구체적인 종류를 나타내는 클래스
 */
class MickeyDoll extends Doll {

    /**
     * Mickey 인형의 가격과 Mickey type정의
     */
    protected MickeyDoll() {
        this.price = new BigInteger("25000");
        this.type = DollType.Mickey;
    }
}

/**
 * Doll을 상속받는 하위 클래스로 Doll에 대한 구체적인 종류를 나타내는 클래스
 */
class RyanDoll extends Doll {

    /**
     * Ryan 인형의 가격과 Ryan type정의
     */
    protected RyanDoll() {
        this.price = new BigInteger("15000");
        this.type = DollType.Ryan;
    }
}
