package Services.ShipmentDetails;

public class CancelledState implements OrderState{
    @Override
    public void processOrder(OrderContext context) {
        System.out.println("Order has been cancelled, cannot process further. ");
    }

    @Override
    public void shipOrder(OrderContext context) {
        System.out.println("Order has been cancelled, cannot ship. ");
    }

    @Override
    public void deliverOrder(OrderContext context) {
        System.out.println("Order has been cancelled, cannot deliver. ");
    }

    @Override
    public void cancelOrder(OrderContext context) {
        System.out.println("Order is already cancelled. ");
    }
}
