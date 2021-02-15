import com.modeliosoft.modelio.javadesigner.annotations.objid;

import PublicServiceLot;
import Player;

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
        this.lot = parent;
    }

    ///Methods

    @Override
    public void ApplyOnPassBy(Player player) {
        //DO NOTHING
    }

    @Override
    public void ApplyOnStop(Player player) {
        if (!this.IsFree())
        {
            //Make the player pay the tax
            int diceSum = player.GetDiceSum();
            int tax = this.rent * this.rentMultiplier * diceSum;
            player.TransferMoney(tax, this.owner);

            //Launch the buying status routine
            player.DisplayBuyingStatus(this);
        }
        else
            //Launch the BuyableTile buy routine
            this.BuyRoutine(player);
    }
}
