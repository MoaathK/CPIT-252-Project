package Services.ShipmentDetails;

public class ShippedState implements OrderState{
    @Override
    public void processOrder(OrderContext context) {
        System.out.println("Order has already been shipped");
    }

    @Override
    public void shipOrder(OrderContext context) {
        System.out.println("Order is already on it's way");
    }

    @Override
    public void deliverOrder(OrderContext context) {
        System.out.println("Delivering your order now");
        context.setState(new DeliveredState());
    }

    @Override
    public void cancelOrder(OrderContext context) {
        System.out.println("Cannot cancel, order is already shipped.");
    }
}
