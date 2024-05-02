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
