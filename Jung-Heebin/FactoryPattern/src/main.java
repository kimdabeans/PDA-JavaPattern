/**
 * default package
 */
import FrameWork.Factory;
import FrameWork.Product;
import IDCard.IDCardFactory;
import Key.KeyFactory;

/**
 * 동작을 test하기 위한 main 클래스
 */
public class main {

	public static void main(String[] args) {
		Factory CardFactory = new IDCardFactory();
		Product card1 = CardFactory.create("HEEBIN");
		card1.use();
		
		
		System.out.println("\n");
		Factory KeyFactory = new KeyFactory();
		Product key1 = KeyFactory.create("YEJI");
		
		key1.use();
	}
}

