package Services.ShipmentDetails;

import Observer.Observer;
import Observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class OrderContext implements Subject {
    private OrderState state;
    private List<Observer> observers = new ArrayList<>();

    public OrderContext() {
        this.state = new ProcessingState();

    }
    public void setState(OrderState state) {
        this.state = state;
    }
    public OrderState getState() {
        return state;
    }
    public void processOrder(){
        this.state.processOrder(this);
    }
    public void shipOrder(){
        this.state.shipOrder(this);
    }
    public void deliverOrder(){
        this.state.deliverOrder(this);
    }
    public void cancelOrder(){
        this.state.cancelOrder(this);
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
}
