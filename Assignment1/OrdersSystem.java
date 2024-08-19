abstract class Order {
	protected int orderId;
	protected long synonymId;
	protected String orderType;
	    
	public Order (int Order_Id, long Synonym_Id, String Order_Type){
		this.orderId = Order_Id;
		this.synonymId = Synonym_Id;
		this.orderType = Order_Type;
		validateOrderType();
		validateSynonymId();
		
	}

	protected abstract void validateSynonymId();

	protected abstract void validateOrderType();
	
	public static Order[] addOrderToArray(Order[] orders, Order newOrder) {
		if(newOrder.orderId > 0) {
			Order[] newOrdersArray = new Order[orders.length + 1];
			System.arraycopy(orders, 0, newOrdersArray, 0, orders.length);
			newOrdersArray[orders.length] = newOrder;
			return newOrdersArray;
		}
		return orders;
		
	}
}

public class OrdersSystem {
    public static void main(String[] args) {
        Order[] orders = new Order[0];  // Initialize an empty order array

        try {
            // Create instances of PrescriptionOrder and NonMedicationOrder
            Order order1 = new PrescriptionOrder(101, 123456, "PRESCRIPTION");
            Order order2 = new NonMedicationOrder(102, 654321, "NON_MEDICATION");

            // Add orders to array
            orders = Order.addOrderToArray(orders, order1);
            orders = Order.addOrderToArray(orders, order2);

            // Display contents of the array
            System.out.println("Orders in the array:");
            for (Order order : orders) {
                System.out.println("Order ID: " + order.orderId + ", Synonym ID: " + order.synonymId + ", Order Type: " + order.orderType);
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            new PrescriptionOrder(103, -1, "INVALID_TYPE");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            new NonMedicationOrder(104, 0, "NON_MEDICATION");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
