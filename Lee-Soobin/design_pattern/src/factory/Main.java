package factory;

import factory.framework.Product;
import factory.idcard.IDCardFactory;

/**
 * Factory 패턴을 테스트하는 메인 클래스.
 */
public class Main {
    public Main() {}

    public static void main(String[] var0) {
        IDCardFactory var1 = new IDCardFactory();
        Product var2 = var1.create("홍길동");
        Product var3 = var1.create("이순신");
        Product var4 = var1.create("강감찬");
        var2.use();
        var3.use();
        var4.use();
    }
}