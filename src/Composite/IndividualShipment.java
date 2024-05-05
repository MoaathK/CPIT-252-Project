package Composite;

import Entities.Shipment;
import Services.ShipmentDetails.OrderContext;

public class IndividualShipment extends Shipment implements ShipmentComponent{


    public IndividualShipment(double weight, String origin, String destination, String carrier) {
        super();
        setWeight(weight);
        setOrigin(origin);
        setDestination(destination);
        setCarrier(carrier);
    }
    @Override
    public void displayShipmentDetails() {
        System.out.println("{ Shipment ID: "+getId()+", Individual Shipment - Origin: " + getOrigin() +
                ", Destination: " + getDestination() + ", Weight: " + getWeight() + " kg"+", Carrier: " + getCarrier()+", Shipment Status: "+getContext().getState().status()+" }");
    }

    @Override
    public double calculateTotalWeight() {
        return getWeight();
    }

    @Override
    public boolean removeShipmentById(String shipmentId) {
        return this.getId().equals(shipmentId);
    }

    @Override
    public boolean matchesSearchCriteria(String criteria, String value) {

        if (criteria.equalsIgnoreCase("id")) {
            return this.getId().equalsIgnoreCase(value);
        }
        else if (criteria.equalsIgnoreCase("origin")) {
            return this.getOrigin().equalsIgnoreCase(value);
        }
        else if (criteria.equalsIgnoreCase("destination")) {
            return this.getDestination().equalsIgnoreCase(value);
        }
        else if (criteria.equalsIgnoreCase("carrier")) {
            return this.getCarrier().equalsIgnoreCase(value);
        }
        return false;

    }

    @Override
    public OrderContext getContext() {
        return context;
    }

    @Override
    public boolean matchesId(String id) {
        return this.getId().equalsIgnoreCase(id);
    }

}
