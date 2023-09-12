package beforeTemplateMethod;

public class Main {
    public static void main(String[] args) {
        SoybeanPasteStew DoenjangJjigae = new SoybeanPasteStew();
        KimchiStew kimchiJjigae = new KimchiStew();

        DoenjangJjigae.makeSoybeanPasteStew();
        System.out.println("--------");
        kimchiJjigae.makeKimchiStew();
    }
}
