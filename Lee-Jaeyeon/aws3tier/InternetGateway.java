package aws3tier;

public class InternetGateway implements IRoutable {
    private String internetGatewayId;
    private String vpcId;
    private String state;

    public InternetGateway(String internetGatewayId) {
        this.internetGatewayId = internetGatewayId;
        this.state = "detached"; // 초기 상태는 detached, attached로 변경가능
    }

    public void attach(String vpcId) {
        if (this.state.equals("attached")) {
            throw new IllegalStateException("The gateway is already attached to a VPC.");
        }
        this.vpcId = vpcId;
        this.state = "attached";
    }

    @Override
    public String getTargetId() {
        return this.internetGatewayId;
    }
}
