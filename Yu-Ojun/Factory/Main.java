package Factory;

import Factory.framework.Factory;
import Factory.framework.Product;
import Factory.securities.SecuritiesFactory;
/**
 * 파생결합증권 상품을 생성하는 Factory 패턴을 사용하는 서비스의 메인 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new SecuritiesFactory();

        Product ELS = factory.create("Yu O Jun", "ELS product");
        Product ELW = factory.create("David Beckham","ELW product");
        Product DLS = factory.create("Park Ji Sung","DLS product");

        ELS.use();
        ELW.use();
        DLS.use();
    }
}
