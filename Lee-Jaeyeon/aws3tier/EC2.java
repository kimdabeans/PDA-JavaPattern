package aws3tier;

import java.util.List;
import java.util.Random;

public class EC2 {

    private InstanceType instanceType;
    private AMI ami;
    private String instanceId;
    private List<SecurityGroup> securityGroups;
    private String vpcId;
    private String subnetId;
    private String privateIp;
    private String publicIp;
    private InstanceState instanceState;
    private int currentConnections; // LeastConnectionsStrategy에 사용할 멤버변수

    public EC2(EC2Configuration config) {
        this.instanceType = config.getInstanceType();
        this.ami = config.getAmi();
        this.instanceId = config.getInstanceId();
        this.securityGroups = config.getSecurityGroups();
        this.vpcId = config.getVpcId();
        this.subnetId = config.getSubnetId();
        this.privateIp = config.getPrivateIp();
        this.publicIp = config.getPublicIp();
        this.instanceState = InstanceState.PENDING; // 생성 시 PENDING
    }

    public String getPrivateIp() {
        return this.privateIp;
    }

    public InstanceState getInstanceState() {
        return instanceState;
    }

    public int getCurrentConnections() {
        return currentConnections;
    }

    public void startInstance() {
        if (instanceState == InstanceState.PENDING) {
            this.instanceState = InstanceState.RUNNING;
            setRandomConnections();
        }
        // ELB LeastConnectionsStrategy에 사용됩니다.
    }

    private void setRandomConnections() {
        Random random = new Random();
        this.currentConnections = random.nextInt(4);
    }
}
