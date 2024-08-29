abstract class Order {
    protected int orderId;
    protected Long synonymId;
    protected String orderType;

    // Parameterized constructor
    public Order(int orderId, Long synonymId, String orderType) {
        this.orderId = orderId;
        this.synonymId = synonymId;
        this.orderType = orderType;
    }

    // Abstract method to validate order type
    protected abstract void validateOrderType();

    // Abstract method to validate synonym id
    protected abstract void validateSynonymId();

    // Instance method to add the current order to an array
    public Order[] addOrderToArray(Order[] orders) {
    	if (this.orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be greater than 0.");
        }
        // Create a new array with an additional slot for the new order
        Order[] newOrdersArray = new Order[orders.length + 1];
        System.arraycopy(orders, 0, newOrdersArray, 0, orders.length);
        newOrdersArray[orders.length] = this;
        return newOrdersArray;
    }
}



public class OrdersSystem {
    public static void main(String[] args) {
        // Initialize an empty order array
        Order[] orders = new Order[0];

        // Array of orders to process
        Order[] ordersToProcess = {
            new PrescriptionOrder(103, null), // Invalid synonymId
            new NonMedicationOrder(104, -7L), // Invalid synonymId
            new PrescriptionOrder(-7, 123456L), // Invalid orderId
            new NonMedicationOrder(0, 123456L), // Invalid orderId
            new PrescriptionOrder(105, null, "NORMAL"), // Invalid orderType
            new NonMedicationOrder(106, 123456L, "INVALID"), // Invalid orderType
            new PrescriptionOrder(101, 123456L), // Valid order
            new NonMedicationOrder(102, 654321L) // Valid order
        };

        // Process each order
        for (Order order : ordersToProcess) {
            try {
            	order.validateOrderType();
            	order.validateSynonymId();
                orders = order.addOrderToArray(orders); // Try adding the order to the array
            } catch (IllegalArgumentException e) {
                // Print the error message
                System.out.println("Order ID: " + order.orderId + " - " + e.getMessage());
            }
        }

        // Display contents of the valid orders array
        if (orders.length > 0) {
            System.out.println("\nOrders in the array:");
            for (Order order : orders) {
                System.out.println("Order ID: " + order.orderId + ", Synonym ID: " + order.synonymId + ", Order Type: " + order.orderType);
            }
        } else {
            System.out.println("\nNo valid orders to display.");
        }
    }
}

