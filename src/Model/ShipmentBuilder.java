package Model;

public interface ShipmentBuilder {


    void setOrigin(String origin);
    void setDestination(String destination);
    void setWeight(double weight);
    void setCarrier(String carrier);
    Shipment build();

}
