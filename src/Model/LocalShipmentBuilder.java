package Model;

public class LocalShipmentBuilder implements ShipmentBuilder{
    private  Shipment shipment;
    public LocalShipmentBuilder() {
        this.shipment = new Shipment();
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
