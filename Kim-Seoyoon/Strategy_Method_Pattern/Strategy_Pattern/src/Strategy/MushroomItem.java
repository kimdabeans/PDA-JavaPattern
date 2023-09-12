package Strategy;

/**
 * description    : MushroomItem 인터페이스로 하위 클래스에서 MushroomItem 인터페이스를 구현해서 두 종류의 MushroomItem 중 어떤 능력인지 정의<br>
 * packageName    : Strategy<br>
 * fileName       : MushroomItem<br>
 * author         : seoyun<br>
 * date           : 2023-09-10<br>
 */
public interface MushroomItem
{
    /**
     * 두 가지 종류의 speed item 존재
     */
    public void speed();
}
/**
 * MushroomItem을 구현하는 LongSpeed 클래스로  LongSpeed아이템을 사용했다는 것을 출력
 */
class LongSpeed implements MushroomItem
{
    public void speed()
    {
        System.out.println("LongSpeed");
    }
}
/**
 * MushroomItem을 구현하는 ShortSpeed 클래스로 ShortSpeed아이템을 사용했다는 것을 출력
 */
class ShortSpeed implements MushroomItem
{
    public void speed()
    {
        System.out.println("ShortSpeed");
    }
}

