package Model;

public class InternationalShipmentBuilder implements ShipmentBuilder {
    private Shipment shipment;

    public InternationalShipmentBuilder() {
        this.shipment = new Shipment();
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

