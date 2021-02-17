public class PublicServiceTile extends BuyableTile {

    ///Attributes
    private PublicServiceLot lot;

    ///Constructors
    public PublicServiceTile(String name)
    {
        this.tileName = name;
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
