package aws3tier;

public class Local implements IRoutable {

    private String vpcId;

    public Local(String vpcId) {
        this.vpcId = vpcId;
    }

    @Override
    public String getTargetId() {
        return "local";
    }
    // 라우팅 테이블에서 동일 VPC에 접근하는 기능
}
