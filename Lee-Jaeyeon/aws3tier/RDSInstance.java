package aws3tier;

import java.util.ArrayList;
import java.util.List;

public class RDSInstance {

    private static final List<RDSInstance> instances = new ArrayList<>(2);
    private static final int MAX_INSTANCES = 2;
    private AvailabilityZone az;

    private RDSInstance(AvailabilityZone az) {
        this.az = az;
    }

    public static RDSInstance getInstance(AvailabilityZone az) {
        if (instances.size() < MAX_INSTANCES && !containsAZ(az)) {
            RDSInstance newInstance = new RDSInstance(az);
            instances.add(newInstance);
            return newInstance;
        } else {
            throw new RuntimeException("Maximum instances reached or AZ already has an instance.");
        }
    }

    public AvailabilityZone getAz() {
        return az;
    }

    private static boolean containsAZ(AvailabilityZone az) {
        return instances
                .stream()
                .anyMatch(instance -> instance.getAz().equals(az));
    }

}
