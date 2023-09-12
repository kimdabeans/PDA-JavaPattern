package aws3tier;

import java.util.ArrayList;
import java.util.Random;

public class EC2 {

    private InstanceType instanceType;
    private AMI ami;
    private String instanceId;
    private ArrayList<SecurityGroup> securityGroups;
    private String vpcId;
    private String subnetId;
    private String privateIp;
    private String publicIp;
    private InstanceState instanceState;
    private int currentConnections; // LeastConnectionsStrategy에 사용할 멤버변수

    public EC2(InstanceType instanceType, AMI ami, String instanceId) {
        this.instanceType = instanceType;
        this.ami = ami;
        this.instanceId = instanceId;
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
    }

    private void setRandomConnections() {
        Random random = new Random();
        this.currentConnections = random.nextInt(4);
    }
}
