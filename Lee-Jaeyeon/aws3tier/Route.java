package aws3tier;

public class Route {
    private String destinationCidrBlock;
    private IRoutable target;

    public Route(String destinationCidrBlock, IRoutable target) {
        this.destinationCidrBlock = destinationCidrBlock;
        this.target = target;
    }
    // Routing Table record를 나타내는 클래스


}
