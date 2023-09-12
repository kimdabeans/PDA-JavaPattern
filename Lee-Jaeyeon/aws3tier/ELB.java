package aws3tier;

import java.util.List;

public class ELB {
    // 전략 패턴에서 Context
    private ILoadBalancingStrategy strategy;
    private List<EC2> targetGroup;

    public ELB(ILoadBalancingStrategy strategy, List<EC2> targetGroup) {
        this.strategy = strategy;
        this.targetGroup = targetGroup;
    }

    public EC2 getTargetInstance() {
        return this.strategy.selectInstance(this.targetGroup);
    }

    public void setStrategy(ILoadBalancingStrategy strategy) {
        this.strategy = strategy;
    }
}
