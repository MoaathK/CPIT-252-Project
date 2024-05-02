package Services.ShipmentDetails;

public class DeliveredState implements OrderState{
    @Override
    public void processOrder(OrderContext context) {
        System.out.println("Order has already been delivered. ");
    }

    @Override
    public void shipOrder(OrderContext context) {
        System.out.println("Order has already been delivered ");
    }

    @Override
    public void deliverOrder(OrderContext context) {
        System.out.println("Order has already been delivered ");
    }

    @Override
    public void cancelOrder(OrderContext context) {
        System.out.println("Cannot cancel, order has already been delivered ");
    }
}
