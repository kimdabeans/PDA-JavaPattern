package aws3tier;

import java.util.List;

public class Vpc {
    private String vpcId;
    private String ipv4CidrBlock;
    private String state;
    private List<Subnet> associatedSubnets;
    private List<RoutingTable> routeTables;
    private List<SecurityGroup> securityGroups;
    private List<InternetGateway> internetGateways;
    private List<NatGateway> natGateways;

    public Vpc(String vpcId, String ipv4CidrBlock) {
        this.vpcId = vpcId;
        this.ipv4CidrBlock = ipv4CidrBlock;
        this.state = "Available"; // Pending 생략
    }
}
