package Composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShipmentManager {
    private List<ShipmentComponent> allShipments;

    public ShipmentManager() {
        this.allShipments = new ArrayList<ShipmentComponent>();
    }
    public void setShipment(ShipmentComponent shipment){
        this.allShipments.add(shipment);
    }
    public boolean removeShipmentById(String shipmentId) {
        return allShipments.removeIf(shipment -> shipment.removeShipmentById(shipmentId));
    }
    public ShipmentComponent findShipmentById(String id) {
        return allShipments.stream()
                .filter(shipment -> shipment.getId().equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }



    public void displayAllShipments() {
        if (allShipments.isEmpty()) {
            System.out.println("No shipments available to display.");
            return;
        }
        for (ShipmentComponent shipment : allShipments) {
            shipment.displayShipmentDetails(); // Display each shipment's details
        }
    }
}
