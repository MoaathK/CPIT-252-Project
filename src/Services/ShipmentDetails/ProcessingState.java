package Services.ShipmentDetails;

public class ProcessingState implements OrderState{
    @Override
    public void processOrder(OrderContext context) {
        System.out.println("Your Order is being processed");
        context.setState(new ShippedState());
    }

    @Override
    public void shipOrder(OrderContext context) {
        System.out.println("Shipping Your order Now ");
        context.setState(new ShippedState());
    }

    @Override
    public void deliverOrder(OrderContext context) {
        System.out.println("Order must be shipped first");
    }

    @Override
    public void cancelOrder(OrderContext context) {
        System.out.println("Order Processing cancelled");
        context.setState(new CancelledState());
    }
    
}
