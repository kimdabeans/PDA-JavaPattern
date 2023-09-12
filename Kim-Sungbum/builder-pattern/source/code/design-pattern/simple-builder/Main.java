
/**
 * 이 클래스는 `Article` 클래스의 빌더 패턴을 사용하여 게시글 객체를 생성하고 출력하는 메인 클래스입니다.
 */
public class Main {
    /**
     * 메인 메서드에서는 `Article` 클래스의 빌더를 사용하여 게시글 객체를 생성하고 출력합니다.
     *
     * @param args 커맨드 라인 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        // Article 빌더를 사용하여 게시글 객체를 생성합니다.
        Article build = new Article.Builder("aa", "title", ArticleType.FREE)
                .content("content")
                .build();

        // 생성된 게시글 객체를 출력합니다.
        System.out.println(build);


        ArticleLombok articleLombok = ArticleLombok.builder()
                .id("bb")
                .title("title2")
                .content("content2")
                .articleType(ArticleType.FREE)
                .build();
    }
}
