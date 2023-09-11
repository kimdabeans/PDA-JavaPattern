package aws3tier;

import java.util.ArrayList;
import java.util.List;

public class RoutingTable {

    private String routeTableId; // 고유한 라우팅 테이블 ID
    private String vpcId; // 라우팅 테이블이 연결된 VPC의 ID
    private List<Route> routeList;
    private List<String> associatedSubnets;

    public RoutingTable(String routeTableId, String vpcId) {
        this.routeTableId = routeTableId;
        this.vpcId = vpcId;
        this.routeList = new ArrayList<>(64);
        this.associatedSubnets = new ArrayList<>(64);
    }

    // 라우트 추가 메서드
    public void addRoute(Route route) {
        if (route == null) {
            throw new IllegalArgumentException("Route cannot be null");
        }
        routeList.add(route);
    }

    // 라우트 삭제 메서드
    public void removeRoute(Route route) {
        routeList.remove(route);
    }


}
