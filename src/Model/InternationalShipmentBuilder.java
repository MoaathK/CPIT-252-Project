package Model;

import Services.ShipmentDetails.OrderContext;

public class InternationalShipmentBuilder implements ShipmentBuilder {
    private Shipment shipment;
    private OrderContext context;

    public InternationalShipmentBuilder() {
        this.shipment = new Shipment();
        this.context = new OrderContext();
    }

    public void setOrigin(String origin) {
        shipment.setOrigin(origin);
    }

    public void setDestination(String destination) {
        shipment.setDestination(destination);
    }
    public void setCarrier(String carrier) {
        shipment.setCarrier(carrier);
    }

    public void setWeight(double weight) {
        shipment.setWeight(weight);
    }

    public Shipment build() {
        return shipment;
    }
}

