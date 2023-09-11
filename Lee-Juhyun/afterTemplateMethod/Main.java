package afterTemplateMethod;

public class Main {
    public static void main(String[] args) {
        SoybeanPasteStew DoenjangJjigae = new SoybeanPasteStew();
        KimchiStew kimchiJjigae = new KimchiStew();

        DoenjangJjigae.makeStew();
        System.out.println("--------");
        kimchiJjigae.makeStew();
    }
}
