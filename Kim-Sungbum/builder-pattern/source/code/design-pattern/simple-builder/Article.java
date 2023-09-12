
/**
 * 이 클래스는 게시글(Article) 정보를 나타내는 클래스입니다. 불변 객체로 설계되었으며, 빌더 패턴을 사용하여 객체를 생성합니다.
 */
public class Article {
    // final 키워드로 필드들을 불변 객체로 만든다.
    private final String id;
    private final String title;
    private final String content;
    private final ArticleType articleType;

    /**
     * Article 객체를 생성하기 위한 정적 내부 빌더 클래스입니다.
     */
    public static class Builder {

        // 필수 파라미터
        private final String id;
        private final String title;
        private final ArticleType articleType;

        // 선택 파라미터
        private String content;

        /**
         * 필수 파라미터를 받는 빌더 클래스의 생성자입니다.
         *
         * @param id          게시글 식별자
         * @param title       게시글 제목
         * @param articleType 게시글 유형
         */
        public Builder(String id, String title, ArticleType articleType) {
            this.id = id;
            this.title = title;
            this.articleType = articleType;
        }

        /**
         * 게시글 내용을 설정하는 메서드입니다.
         *
         * @param content 게시글 내용
         * @return 빌더 객체 자신을 반환하여 메서드 체이닝 지원
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        /**
         * Article 객체를 생성합니다.
         *
         * @return 생성된 Article 객체
         */
        public Article build() {
            return new Article(this); // 빌더 객체 자신을 넘깁니다.
        }
    }

    // private 생성자 - 생성자는 외부에서 호출되는 것이 아닌 빌더 클래스에서만 호출되기 때문에
    private Article(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.content = builder.content;
        this.articleType = builder.articleType;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", articleType=" + articleType +
                '}';
    }
}
