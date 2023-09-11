package Factory.framework;

public abstract class Factory {
    public final Product create(String owner, String product){
        Product p = createProduct(owner, product);
        registerProduct(p);
        return p;
    }
    protected abstract Product createProduct(String owner, String product);
    protected abstract void registerProduct(Product product);
}
