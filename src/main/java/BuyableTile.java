public abstract class BuyableTile extends Tile {

    ///Attributes
    protected int rent;

    protected int rentMultiplier;

    protected int cost;

    protected Player owner;

    protected BuyableLot lot;

    ///Constructors

    ///Methods

    public void sell(Player buyer) {
    }

    protected void changeOwnership(Player player) {
        if(owner!=null)owner.removeOwnedTile(this);
        this.owner = player;
        if(player!=null)player.addOwnedTile(this);
        this.lot.onOwnershipChange();
    }

    protected boolean isFree() {
        return this.owner == null;
    }

    protected void buyRoutine(Player player) {
        if (player.canAfford(this.cost)){
            //Display the buying proposition to the player
            if (player.displayBuyingProposition(this)) {
                //The player accepts, we debit him
                player.debit(this.cost);
                //Then we apply the on ownership change subroutine
                this.changeOwnership(player);
                System.out.println(tileName+" was successfully bought by "+player);
            }
        }
        else
        {
            //Player doesn't have enough money to buy the tile, display status and abort
            player.displayBuyingStatus(this);
        }
    }

    public void setRentMultiplier(int multiplier) {
        this.rentMultiplier = multiplier;
    }

    public int getCost()
    {
        return this.cost;
    }

    public void setParent(BuyableLot buyableLot)
    {
        this.lot = buyableLot;
    }

    public Player getOwner(){ return this.owner; }

}
