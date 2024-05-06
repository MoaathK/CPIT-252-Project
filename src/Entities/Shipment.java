package Entities;


import Services.ShipmentDetails.OrderContext;

public class Shipment {
    private static int lastId = 0;
    private String id;
    private String origin;
    private String destination;
    private String carrier;
    private double weight;
    public OrderContext context;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Shipment( ) {
        this.id = String.valueOf(++lastId);
        context = new OrderContext();
    }

    public String getId() {
        return id;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

}

