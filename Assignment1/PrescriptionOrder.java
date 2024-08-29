// Subclass PrescriptionOrder
class PrescriptionOrder extends Order {
    private static final String DEFAULT_ORDER_TYPE = "PRESCRIPTION";

    public PrescriptionOrder(int orderId, Long synonymId) {
        super(orderId, synonymId, DEFAULT_ORDER_TYPE);
    }
    
    public PrescriptionOrder(int orderId, Long synonymId, String orderType) {
        super(orderId, synonymId, orderType);
    }

    @Override
    protected void validateOrderType() {
        if (!orderType.equals(DEFAULT_ORDER_TYPE)) {
            throw new IllegalArgumentException("Invalid order type for PrescriptionOrder.");
        }
    }

    @Override
    protected void validateSynonymId() {
        if (synonymId == null || synonymId <= 0) {
            throw new IllegalArgumentException("Invalid synonym id for PrescriptionOrder.");
        }
    }
}