package aws3tier;

import java.util.List;

public class SecurityGroup {
    private String sgId;
    private String vpcId;
    private List<Rule> rules;


    // Rule 클래스는 SecurityGroup에 종속적이지만, SecurityGroup의 내부 상태에 직접 접근할 필요는 없음
    // => static nested 클래스로 구현

    public abstract static class Rule {
        protected String protocol;
        protected String portRange;

    }

    public static class Inbound extends Rule {
        private String source; // CIDR notation for the source IP range

    }

    public static class Outbound extends Rule {
        private String destination; // CIDR notation for the destination IP range

    }

}
