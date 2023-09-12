package aws3tier;

public class Subnet {
    private String subnetId; // 고유한 서브넷 ID
    private String vpcId; // 해당 서브넷이 속한 VPC ID
    private AvailabilityZone az; // 서브넷이 위치한 가용 영역
    private String CIDR_block; // CIDR 블록
}
