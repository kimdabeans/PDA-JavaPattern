package aws3tier;

import java.util.List;
import java.util.stream.Collectors;

public class IPHashStrategy implements ILoadBalancingStrategy {
    @Override
    public EC2 selectInstance(List<EC2> instances) {
        if (instances.isEmpty()) {
            throw new RuntimeException("No available instances");
        }

        List<EC2> runningInstances = instances.stream()
                .filter(instance -> instance.getInstanceState().equals(InstanceState.RUNNING))
                .collect(Collectors.toList());

        int hashValue = runningInstances.get(0).getPrivateIp().hashCode();
        int index = Math.abs(hashValue) % runningInstances.size();
        return runningInstances.get(index);
    }
}
