
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * ArticleLombok 클래스는 불변의 게시물 정보를 나타내는 클래스입니다.
 * 이 클래스는 Lombok의 @AllArgsConstructor와 @Builder 어노테이션을 사용하여 생성자 및 빌더 패턴을 제공합니다.
 */
public class ArticleLombok {
    /**
     * 게시물의 고유한 식별자를 나타내는 문자열입니다.
     */
    private final String id;

    /**
     * 게시물의 제목을 나타내는 문자열입니다.
     */
    private final String title;

    /**
     * 게시물의 내용을 나타내는 문자열입니다.
     */
    private final String content;

    /**
     * 게시물의 유형을 나타내는 ArticleType 열거형 객체입니다.
     * ArticleType은 게시물의 종류를 정의합니다.
     *
     * @see ArticleType
     */
    private final ArticleType articleType;
}
