
public class NonMedicationOrder extends Order {
	public NonMedicationOrder(int Order_Id, long Synonym_Id, String Order_Type) {
		super(Order_Id, Synonym_Id, Order_Type);
	}
	
	@Override
    protected void validateOrderType() {
        if (!"NON_MEDICATION".equals(orderType)) {
            throw new IllegalArgumentException("Invalid order type for NonMedicationOrder.");
        }
    }

    @Override
    protected void validateSynonymId() {
        if (synonymId<= 0) {
            throw new IllegalArgumentException("Invalid synonym id for NonMedicationOrder.");
        }
    }
}
