package Composite;

import Services.ShipmentDetails.OrderContext;

public interface ShipmentComponent {
    void displayShipmentDetails();
    double calculateTotalWeight();
    boolean removeShipmentById(String shipmentId);
    boolean matchesSearchCriteria(String criteria, String value);
    String getId();
    OrderContext getContext();
}
