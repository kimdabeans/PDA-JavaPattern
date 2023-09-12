package aws3tier;

public class AddRouteCommand implements ICommand {

    private RoutingTable routingTable;
    private Route route;

    public AddRouteCommand(RoutingTable routingTable, Route route) {
        this.routingTable = routingTable;
        this.route = route;
    }

    @Override
    public void execute() {
        this.routingTable.addRoute(this.route);
        System.out.println(this.route.toString() + " added to the routing table!");
    }
}
