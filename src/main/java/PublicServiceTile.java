public class PublicServiceTile extends BuyableTile {

    ///Attributes
    private PublicServiceLot lot;

    ///Constructors
    public PublicServiceTile(String name)
    {
        this.tileName = name;
    }

    public PublicServiceTile(String name, PublicServiceLot parent)
    {
        this.tileName = name;
        this.lot = parent;
        parent.addChild(this);
    }

    ///Methods
    @Override
    public void applyOnPassBy(Player player) {
        //DO NOTHING
    }

    @Override
    public void applyOnStop(Player player) {
        if (!this.isFree())
        {
            //Make the player pay the tax
            int diceSum = player.getDiceSum();
            int tax = this.rent * this.rentMultiplier * diceSum;
            player.transferMoney(tax, this.owner);

            //Launch the buying status routine
            player.displayBuyingStatus(this);
        }
        else
            //Launch the BuyableTile buy routine
            this.buyRoutine(player);
    }
}
