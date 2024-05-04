package Composite;

import Services.ShipmentDetails.OrderContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupedShipment implements ShipmentComponent{
    private List<ShipmentComponent> shipments = new ArrayList<>();
    private String id;



    @Override
    public void displayShipmentDetails() {
        System.out.println("Grouped Shipment Details:");
        for (ShipmentComponent shipment : shipments) {
            shipment.displayShipmentDetails();
        }
    }

    @Override
    public double calculateTotalWeight() {
        double total = 0;
        for (ShipmentComponent shipment : shipments) {
            total += shipment.calculateTotalWeight();
        }
        return total;
    }

    @Override
    public boolean removeShipmentById(String shipmentId) {
        for (Iterator<ShipmentComponent> iterator = shipments.iterator(); iterator.hasNext();) {
            ShipmentComponent shipment = iterator.next();
            if (shipment.removeShipmentById(shipmentId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean matchesSearchCriteria(String criteria, String value) {
        return shipments.stream().anyMatch(shipment -> shipment.matchesSearchCriteria(criteria, value));
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public OrderContext getContext() {
        return null;
    }

    @Override
    public boolean matchesId(String id) {
        if (this.id != null && this.id.equalsIgnoreCase(id)) {
            return true;
        }
        return shipments.stream().anyMatch(shipment -> shipment.matchesId(id));
    }
}
