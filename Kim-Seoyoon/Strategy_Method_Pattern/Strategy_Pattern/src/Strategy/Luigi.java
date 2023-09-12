package Strategy;

/**
 * description    : MARIOKART 클래스를 상속받아 각각의 캐릭터를 구체화하고 인스턴스 생성 후 자신의 아이템을 출력한다고 정의<br>
 * packageName    : Strategy<br>
 * fileName       : Luigi<br>
 * author         : seoyun<br>
 * date           : 2023-09-10<br>
 */
public class Luigi extends MARIOKART {
    /**
     * MARIOKART를 상속받은 Luigi캐릭터를 구현하는 클래스
     * @param mushroomItem
     * @param bananaItem
     * MushroomItem 인터페이스와 BananaItem 인터페이스를 사용하기 위해 생성자 매개변수로 전달
     */
    public Luigi(MushroomItem mushroomItem,
                 BananaItem bananaItem)
    {
        super(mushroomItem,bananaItem);
    }
    /**
     * Luigi 순서가 시작하는 것을 알려주기 위한 메소드
     */
    public void display()
    {
        System.out.println("Luigi");
    }
}
