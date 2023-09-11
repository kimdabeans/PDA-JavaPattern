package Factory;

import Factory.framework.Factory;
import Factory.framework.Product;
import Factory.securities.SecuritiesFactory;

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
