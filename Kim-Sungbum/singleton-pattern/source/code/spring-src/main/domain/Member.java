
import lombok.Getter;

/**
 * Member class
 * 이 클래스는 회원 정보를 나타내는 데이터 모델 클래스입니다.
 * @author kim sungbum
 */
@Getter
public class Member {

    /**
     * 회원의 고유 식별자(ID)입니다.
     */
    private Long id;

    /**
     * 회원의 이름입니다.
     */
    private String name;

    /**
     * 기본 생성자입니다.
     * 새로운 회원 객체를 생성할 때 사용됩니다.
     */
    public Member() {
    }

    /**
     * 회원 객체를 생성하는 생성자입니다.
     *
     * @param id   회원의 고유 식별자(ID)
     * @param name 회원의 이름
     */
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 회원의 고유 식별자(ID)를 반환합니다.
     *
     * @return 회원의 고유 식별자(ID)
     */
    public Long getId() {
        return id;
    }

    /**
     * 회원의 이름을 반환합니다.
     *
     * @return 회원의 이름
     */
    public String getName() {
        return name;
    }
}
