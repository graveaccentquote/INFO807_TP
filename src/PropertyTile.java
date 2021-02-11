import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e7634c5b-ad1c-499e-9dd5-231e8471a026")
public class PropertyTile extends BuyableTile {
    @objid ("35746424-bd98-46ad-bc01-31f4dbab67ba")
    private int buildingCount;

    @objid ("2ad7505f-be7a-4fde-8c38-63e582f9ed2d")
    private int[] buildingRents = new int[5];

    @objid ("142bd902-71af-4257-8fba-2b2d22820ec6")
    private int buildingCost;

    @objid ("df7c0b8a-b116-44cf-9e98-41b5bed67dae")
    public PropertyLot lot;

    @objid ("30c5e16d-5575-4703-ab36-5e83edf39595")
    public PropertyState state;

    @objid ("2c33ec2b-dfe7-4eb3-8b9c-8964fb48bf23")
    public void Build() {
    }

    @objid ("81660507-a19d-4f03-844c-8361e7008965")
    public void BecomeConstructible() {
    }

    @objid ("45e78abd-2705-411b-b75e-b88d558ddd2e")
    public void BecomeUnconstructible() {
    }

    @objid ("282ab172-fa28-48b3-8673-79536e5dc863")
    public void SellBuilding() {
    }

}
