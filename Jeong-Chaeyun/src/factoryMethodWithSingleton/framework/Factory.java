package factoryMethodWithSingleton.framework;

public interface Factory {

	Product planProduct(String type);

	void readyProduct(Product product);

	default Product create(String type) {
		Product p = planProduct(type);
		readyProduct(p);
		return p;
	}
}
