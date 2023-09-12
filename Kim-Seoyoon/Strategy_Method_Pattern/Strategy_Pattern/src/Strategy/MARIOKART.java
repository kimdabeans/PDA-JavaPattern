package Strategy;

/**
 * description    : MARIOKART추상클래스로 상속받을 하위 클래스에서 사용할 메소드와 생성자를 정의하는 클래스<br>
 * packageName    : Strategy<br>
 * fileName       : MARIOKART<br>
 * author         : seoyun<br>
 * date           : 2023-09-10<br>
 */
public abstract class MARIOKART
{
    /**
     * MARIOKART 생성자에서 필요한 변수 설정
     */
    BananaItem bananaItem;
    MushroomItem mushroomItem;

    /**
     * MARIOKART 생성자로 각 Item에 대한 인터페이스를 사용하기 위해 매개변수 전달
     * @param mushroomItem
     * @param bananaItem
     */
    public MARIOKART(MushroomItem mushroomItem,
                    BananaItem bananaItem)
    {
        this.mushroomItem = mushroomItem;
        this.bananaItem = bananaItem;
    }

    /**
     * 사용한 item 목록을 나타내는 메소드
     */
    public void getitem()
    {
        System.out.println("사용한 아이템");
    }

    /**
     * 어떤 종류의 bananaItem인지를 나타내는 slide 메소드
     */
    public void slide()
    {
        bananaItem.slide();
    }
    /**
     * 어떤 종류의 mushroomItem인지를 나타내는 speed 메소드
     */
    public void speed()
    {
        mushroomItem.speed();
    }
    /**
     * 바나나 아이템 설정
     * @param bananaItem 설정할 바나나 아이템 객체
     */
    public void setBananaItem(BananaItem bananaItem)
    {
        this.bananaItem = bananaItem;
    }
    /**
     * 버섯 아이템 설정
     * @param mushroomItem 설정할 버섯 아이템 객체
     */
    public void setMushroomItem(MushroomItem mushroomItem)
    {
        this.mushroomItem = mushroomItem;
    }

    /**
     * 어떤 캐릭터가 어떤 item을 사용했는지 알려주기 위한 메소드
     */
    public abstract void display();
}
