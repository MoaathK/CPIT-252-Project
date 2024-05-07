package Observer;

import Services.ShipmentDetails.OrderState;

public interface Observer {
    void update(OrderState state);
}
