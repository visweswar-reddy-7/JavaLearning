
public class PrescriptionOrder extends Order{
	public PrescriptionOrder(int Order_Id, long Synonym_Id, String Order_Type) {
		super(Order_Id, Synonym_Id, Order_Type);
	}
	
	@Override
    protected void validateOrderType() {
        if (!"PRESCRIPTION".equals(orderType)) {
            throw new IllegalArgumentException("Invalid order type for PrescriptionOrder.");
        }
    }

    @Override
    protected void validateSynonymId() {
        if (synonymId<= 0) {
            throw new IllegalArgumentException("Invalid synonym id for PrescriptionOrder.");
        }
    }
}
