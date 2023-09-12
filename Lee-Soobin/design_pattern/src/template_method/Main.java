package template_method;
/**
 * Template Method 패턴을 테스트하는 Main 클래스.
 *
 * @author Template_Method
 * @version 1.0
 */
public class Main {

    public static void main(String[] var0) {
        // 'H'를 가진 CharDisplay 인스턴스를 1개 만든다
        AbstractDisplay d1 =  new CharDisplay('H');
        AbstractDisplay d2 =  new StringDisplay("Hello");
        AbstractDisplay d3 = new StringDisplay("안녕하세요");

        // d1, d2, d3 모두 AbstractDisplay의 하위 클래스의 인스턴스이므로 상속한 display 메서드 호출
        // 실제 동작은 CharDisplay나 StringDisplay에서 결정한다
        d1.display();
        d2.display();
        d3.display();
    }
}