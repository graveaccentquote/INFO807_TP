import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("56363185-6c49-4415-a18b-abf102c268d4")
public abstract class BuyableTile implements Tile {
    @objid ("64fa0212-1202-408f-a2b0-c55b0839852f")
    private int rent;

    @objid ("47b3a17b-7b7f-445c-980e-1b1ee20d9731")
    private int rentMultiplier;

    @objid ("25e80dcb-737c-44f2-bbb6-81ae069d0b88")
    private int cost;

    @objid ("808df7c5-40f2-4827-9081-03d89fc9c06b")
    public Player owner;

    @objid ("33941555-153b-4653-b913-e53598933c4e")
    public void Sell(Player buyer) {
    }

    @objid ("d80cc57b-f8df-498c-8f09-791203b146a7")
    private void ChangeOwnership(Player player) {
    }

    @objid ("4f7bea4e-cbd2-47d8-a762-11166a99d9ee")
    private boolean IsFree() {
    }

    @objid ("8125d715-f525-45f0-8b71-75abb6943bbb")
    private void BuyRoutine(Player player) {
    }

    @objid ("c8d26b2f-a20f-46f1-8d11-9bd9cead1337")
    public void SetRentMultiplier(int multiplier) {
    }

}
