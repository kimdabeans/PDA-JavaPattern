package aws3tier;

import java.util.Comparator;
import java.util.List;

public class LeastConnectionsStrategy implements ILoadBalancingStrategy {
    @Override
    public EC2 selectInstance(List<EC2> instances) {
        if (instances.isEmpty()) {
            throw new RuntimeException("No available instances");
        }

        return instances.stream()
                .filter(instance -> instance.getInstanceState().equals(InstanceState.RUNNING))
                .min(Comparator.comparingInt(EC2::getCurrentConnections))
                .orElseThrow(() -> new RuntimeException("No available RUNNING instances"));
    }
}
