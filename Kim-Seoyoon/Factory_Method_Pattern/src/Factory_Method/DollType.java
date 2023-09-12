package Factory_Method;

/**
 * description    : 열거형 enum을 사용하여 다양한 종류의 인형을 정의<br>
 * fileName       : DollType<br>
 * author         : seoyun<br>
 * date           : 2023-09-09<br>
 */
public enum DollType {
    /**
     * 푸 인형
     */
    Pooh("푸"),
    /**
     * 미키 인형
     */
    Mickey("미키"),
    /**
     * 라이언 인형
     */
    Ryan("라이언");

    private final String name;

    /**
     * 열거형 상수의 이름 설정
     * @param name 인형의 이름
     */

    private DollType(String name)
    {
        this.name = name;
    }

    /**
     * 인형의 이름 반환
     * @return 인형의 이름
     */
    public String getName()
    {
        return name;
    }
}
