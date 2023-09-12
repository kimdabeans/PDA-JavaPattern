package aws3tier;

import java.util.List;

public interface ILoadBalancingStrategy {
    EC2 selectInstance(List<EC2> instances);
}
