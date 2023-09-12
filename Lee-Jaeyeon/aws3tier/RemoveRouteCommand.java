package aws3tier;

public class RemoveRouteCommand implements ICommand {

    private RoutingTable routingTable;
    private Route route;

    public RemoveRouteCommand(RoutingTable routingTable, Route route) {
        this.routingTable = routingTable;
        this.route = route;
    }

    @Override
    public void execute() {
        this.routingTable.removeRoute(this.route);
        System.out.println(this.route.toString() + " removed!");
    }
}
