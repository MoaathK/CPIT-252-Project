package Model;

import Services.ShipmentDetails.OrderContext;
import Services.ShipmentDetails.OrderState;

public class LocalShipmentBuilder implements ShipmentBuilder{
    private  Shipment shipment;
    private OrderContext context;
    public LocalShipmentBuilder() {
        this.shipment = new Shipment();
        this.context = new OrderContext();
    }

    @Override
    public void setOrigin(String origin) {
    }

    @Override
    public void setDestination(String destination) {
    }

    @Override
    public void setWeight(double weight) {
    }

    @Override
    public void setCarrier(String carrier) {
    }

    @Override
    public Shipment build() {
        return shipment;
    }


}
