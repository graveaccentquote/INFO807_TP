import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("143744b2-1a89-478c-8c89-58f6634bd37a")
public class LuxuryTaxTile extends Tile {

    ///Attributes
    @objid ("9d23456e-882d-4ac0-be57-205a7aae64b2")
    private final int flatTax;

    ///Constructors
    public LuxuryTaxTile()
    {
        this.tileName = "LUXURY TAX";
        this.flatTax = 75;
    }

    ///Methods
    @objid ("99a2f26a-8a44-4597-a71f-9671aea6287c")
    public void ApplyOnStop(Player player) {
        player.Debit(this.flatTax);
    }

    @objid ("ce6e6d11-45f2-454f-92c4-f2398ee9e169")
    public void ApplyOnPassBy(Player player) {
        //DO NOTHING
    }

}
