package Factory.securities;

import Factory.framework.Product;

public class Securities extends Product {
    private String owner;
    private String product;

    Securities(String owner, String product){
        System.out.println("Make " + owner + "'s account");
        this.owner = owner;
        this.product = product;
    }

    @Override
    public void use() {
        System.out.println(getOwner() +"'s " + getProduct() + " use.");
    }

    @Override
    public String toString() {
        return "[Product:" + getProduct() + "] ";
    }

    public String getOwner() {
        return owner;
    }

    public String getProduct() {
        return product;
    }
}
