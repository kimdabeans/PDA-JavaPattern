package aws3tier;

import java.util.ArrayList;

public class EC2Builder implements IAmazonResourceBuilder<EC2> {

    private EC2Configuration.ConfigBuilder configBuilder;

    public EC2Builder() {
        this.configBuilder = new EC2Configuration.ConfigBuilder();
    }

    @Override
    public EC2 build() {
        EC2Configuration config = this.configBuilder.build();
        return new EC2(config);
    }

    public EC2Builder setInstanceType(InstanceType instanceType) {
        this.configBuilder.setInstanceType(instanceType);
        return this;
    }

    public EC2Builder setAmi(AMI ami) {
        this.configBuilder.setAmi(ami);
        return this;
    }

    public EC2Builder setInstanceId(String instanceId) {
        this.configBuilder.setInstanceId(instanceId);
        return this;
    }

    public EC2Builder setSecurityGroups(ArrayList<SecurityGroup> securityGroups) {
        this.configBuilder.setSecurityGroups(securityGroups);
        return this;
    }

    public EC2Builder setVpcId(String vpcId) {
        this.configBuilder.setVpcId(vpcId);
        return this;
    }

    public EC2Builder setSubnetId(String subnetId) {
        this.configBuilder.setSubnetId(subnetId);
        return this;
    }

    public EC2Builder setPrivateIp(String privateIp) {
        this.configBuilder.setPrivateIp(privateIp);
        return this;
    }

    public EC2Builder setPublicIp(String publicIp) {
        this.configBuilder.setPublicIp(publicIp);
        return this;
    }
}
