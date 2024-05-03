package Services.ShipmentDetails;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new ProcessingState();

    }
    public void setState(OrderState state) {
        this.state = state;
    }
    public OrderState getState() {
        return state;
    }
    public void processOrder(){
        this.state.processOrder(this);
    }
    public void shipOrder(){
        this.state.shipOrder(this);
    }
    public void deliverOrder(){
        this.state.deliverOrder(this);
    }
    public void cancelOrder(){
        this.state.cancelOrder(this);
    }

}
