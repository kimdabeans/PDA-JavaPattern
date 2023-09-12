package Strategy;

/**
 * description    : BananaItem 인터페이스로 하위 클래스에서 BananaItem 인터페이스를 구현해서 두 종류의 BananaItem 중 어떤 능력인지 정의<br>
 * packageName    : Strategy<br>
 * fileName       : BananaItem<br>
 * author         : seoyun<br>
 * date           : 2023-09-10<br>
 */
public interface BananaItem
{
    /**
     * 두 가지 종류의 slide item 존재
     */
    public void slide();
}

/**
 * BananaItem을 구현하는 LongSlide 클래스로  LongSlide아이템을 사용했다는 것을 출력
 */
class LongSlide implements BananaItem
{
    public void slide()
    {
        System.out.println("LongSlide");
    }
}
/**
 * BananaItem을 구현하는 ShortSlide 클래스로  ShortSlide아이템을 사용했다는 것을 출력
 */
class ShortSlide implements BananaItem
{
    public void slide()
    {
        System.out.println("ShortSlide");
    }
}

