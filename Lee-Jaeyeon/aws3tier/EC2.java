package aws3tier;

import java.util.ArrayList;

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

}
