package Factory.securities;

import Factory.framework.Factory;
import Factory.framework.Product;

public class SecuritiesFactory extends Factory {
    @Override
    protected Product createProduct(String owner, String product) {
        return new Securities(owner, product);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "has been registered.");
    }
}
