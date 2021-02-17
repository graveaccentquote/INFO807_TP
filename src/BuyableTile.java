import com.modeliosoft.modelio.javadesigner.annotations.objid;

import Player;

@objid ("56363185-6c49-4415-a18b-abf102c268d4")
public abstract class BuyableTile extends Tile {

    ///Attributes
    @objid ("64fa0212-1202-408f-a2b0-c55b0839852f")
    private int rent;

    @objid ("47b3a17b-7b7f-445c-980e-1b1ee20d9731")
    private int rentMultiplier;

    @objid ("25e80dcb-737c-44f2-bbb6-81ae069d0b88")
    private int cost;

    @objid ("808df7c5-40f2-4827-9081-03d89fc9c06b")
    public Player owner;

    protected BuyableLot lot;

    ///Constructors

    ///Methods

    @objid ("33941555-153b-4653-b913-e53598933c4e")
    public void Sell(Player buyer) {
    }

    @objid ("d80cc57b-f8df-498c-8f09-791203b146a7")
    private void ChangeOwnership(Player player) {
        this.owner = player;
        this.lot.OnOwnershipChange();
    }

    @objid ("4f7bea4e-cbd2-47d8-a762-11166a99d9ee")
    protected boolean IsFree() {
        return this.owner == null;
    }

    @objid ("8125d715-f525-45f0-8b71-75abb6943bbb")
    protected void BuyRoutine(Player player) {
        if (player.CanAfford(this.cost)){
            //Display the buying proposition to the player
            if (player.DisplayBuyingProposition(this)) {
                //The player accepts, we debit him
                player.Debit(this.cost);

                //Then we apply the on ownership change subroutine
                this.ChangeOwnership(player);
            }
        }
        else
        {
            //Player doesn't have enough money to buy the tile, display status and abort
            player.DisplayBuyingStatus(this);
        }

    }

    @objid ("c8d26b2f-a20f-46f1-8d11-9bd9cead1337")
    public void SetRentMultiplier(int multiplier) {
        this.rentMultiplier = multiplier;
    }

    public int GetCost()
    {
        return this.cost;
    }

    public void SetParent(BuyableLot buyableLot)
    {
        this.lot = buyableLot;
    }

}
