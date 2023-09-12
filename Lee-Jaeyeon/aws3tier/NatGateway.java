package aws3tier;

public class NatGateway implements IRoutable {

    private String natGatewayId;
    private String vpcId;
    private String subnetId;
    private String state;
    private String elasticIpAddress;
    private String connectivityType;

    public NatGateway(String natGatewayId, String vpcId, String subnetId, String state,
                      String elasticIpAddress, String connectivityType) {
        this.natGatewayId = natGatewayId;
        this.vpcId = vpcId;
        this.subnetId = subnetId;
        this.state = state;
        this.elasticIpAddress = elasticIpAddress;
        this.connectivityType = connectivityType;
    }

    public NatGateway(String natGatewayId, String vpcId, String subnetId) {
        this.natGatewayId = natGatewayId;
        this.vpcId = vpcId;
        this.subnetId = subnetId;

        // 기본값 설정 (추후에 변경 가능)
        this.state = "pending";  // 초기 상태 예
        this.elasticIpAddress = null;  // 초기에 EIP는 할당되지 않았을 수 있음
        this.connectivityType = "public";  // 예상되는 기본 연결 유형
    }

    @Override
    public String getTargetId() {
        return this.natGatewayId;
    }
}
