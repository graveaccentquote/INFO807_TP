public abstract class BuyableTile extends Tile {

    ///Attributes
    protected int rent;

    protected int rentMultiplier;

    protected int cost;

    public Player owner;

    protected BuyableLot lot;

    ///Constructors

    ///Methods

    public void Sell(Player buyer) {
    }

    private void ChangeOwnership(Player player) {
        this.owner = player;
        this.lot.OnOwnershipChange();
    }

    protected boolean IsFree() {
        return this.owner == null;
    }

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
