package java0825_builder2;

/**
 * User 클래스는 Builder 패턴 예제를 실행하는 데 사용됩니다.
 * 이 클래스는 CSVBuilder 및 HTMLBuilder를 사용하여 다양한 형식의 텍스트 문서를 생성하고 출력합니다.
 * @author Cho Hayoung 
 */
public class User {

    public static void main(String[] args) {
    	//커피 레시피 생성 
    	coffeeRecipe latte = new coffeeRecipe.coffeeBuilder(false)
    			.size(4)
    			.espresso(3)
    			.milk(20)
    			.water(0)
    			.sugar(5)
    			.build();
    				
        // Builder 인스턴스 생성
        Builder text = new textBuilder();
        Builder html = new HTMLBuilder();
        // CSVBuilder를 이용하여 Director 인스턴스 생성
        Director hayoung = new Director(text);


        // CSV 형식 문서 생성 및 출력
        String csvTest = hayoung.makeStr("Latte Recipe in csv", latte);
        System.out.println(csvTest);

        // HTMLBuilder를 이용하여 Director 인스턴스 생성
        Director hyoung = new Director(html);

        // HTML 형식 문서 생성 및 출력
        System.out.println(hyoung.makeStr("Latte Recipe in html", latte));
    }
}