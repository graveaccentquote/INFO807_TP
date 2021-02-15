import com.modeliosoft.modelio.javadesigner.annotations.objid;

import PublicServiceLot;

@objid ("39a11fa0-e1bb-44b0-a3c4-668d7fb2abc5")
public class PublicServiceTile extends BuyableTile {

    ///Attributes
    @objid ("0cadec24-5c1b-4702-a420-c6d3746b1b72")
    private PublicServiceLot lot;

    ///Constructors
    public PublicServiceTile(String name)
    {
        this.tileName = name;
    }

    public void SetParent(PublicServiceLot parent) {
        lot = parent;
    }
}
