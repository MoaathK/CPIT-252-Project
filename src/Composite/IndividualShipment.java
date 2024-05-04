package Composite;

import Model.Shipment;
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
        switch (criteria.toLowerCase()) {
            case "id":
                return this.getId().equals(value);
            case "origin":
                return this.getOrigin().equalsIgnoreCase(value);
            case "destination":
                return this.getDestination().equalsIgnoreCase(value);
            case "carrier":
                return this.getCarrier().equalsIgnoreCase(value);
            default:
                return false;
        }
    }

    @Override
    public OrderContext getContext() {
        return context;
    }


    public void printShipmentDetails(){
        System.out.println("Individual Shipment - Origin: " + getOrigin());
        System.out.println("Individual Shipment - Destination: " + getDestination());
        System.out.println("Individual Shipment - Weight: " + getWeight());
        System.out.println("Individual Shipment - Carrier: " + getCarrier());
        System.out.println("Individual Shipment - Total Weight: " + getWeight());

    }

}
