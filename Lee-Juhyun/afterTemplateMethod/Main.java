package afterTemplateMethod;

/**
 * 주된 실행 클래스입니다. 김치찌개와 된장찌개를 만들어 출력합니다.
 */
public class Main {
    public static void main(String[] args) {
        SoybeanPasteStew DoenjangJjigae = new SoybeanPasteStew();
        KimchiStew kimchiJjigae = new KimchiStew();

        // 된장찌개 만들기
        DoenjangJjigae.makeStew();
        System.out.println("--------");

        // 김치찌개 만들기
        kimchiJjigae.makeStew();
    }
}
