package Model;


import Services.ShipmentDetails.OrderContext;

public class Shipment {
    private static int lastId = 0;
    private String id;
    private String origin;
    private String destination;
    private String carrier;
    private double weight;
    public OrderContext context;


    public Shipment( ) {
        this.id = String.valueOf(++lastId);
        context = new OrderContext();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Shipment Info {" +
                "id No='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", carrier='" + carrier + '\'' +
                ", weight=" + weight +
                ", Shipment status= "+context.getState().status()+ '}';
    }
}

