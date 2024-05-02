package Model;

public class Route {
    private int id;
    private String startPoint;
    private String endPoint;
    private int distance;
    private String estimateTime;
    public Route(int id, String startPoint, String endPoint, int distance, String estimateTime) {
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
        this.estimateTime = estimateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setEstimateTime(String estimateTime) {
        this.estimateTime = estimateTime;
    }

    public int getId() {
        return id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public int getDistance() {
        return distance;
    }

    public String getEstimateTime() {
        return estimateTime;
    }
}
/*
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

 */