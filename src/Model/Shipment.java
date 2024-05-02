package Model;

public class Shipment {
    private int id;
    private String origin;
    private String destination;
    private double weight;
    private String status;
    public Shipment(int id, String origin, String destination, double weight, String status) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }
}
