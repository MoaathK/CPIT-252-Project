package Services.ShipmentDetails;

public interface OrderState {
    void processOrder(OrderContext context);
    void shipOrder(OrderContext context);
    void deliverOrder(OrderContext context);
    void cancelOrder(OrderContext context);
    String status();

}
