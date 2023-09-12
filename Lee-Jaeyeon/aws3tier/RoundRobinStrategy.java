package aws3tier;

import java.util.List;

public class RoundRobinStrategy implements ILoadBalancingStrategy {
    private int currentIndex = -1;

    @Override
    public EC2 selectInstance(List<EC2> instances) {
        if (instances.isEmpty()) {
            throw new RuntimeException("No available instances");
        }

        this.currentIndex = (this.currentIndex + 1) % instances.size();
        return instances.get(this.currentIndex);
    }
}
