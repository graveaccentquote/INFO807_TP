public class TrainStationTile extends BuyableTile {

    private final int trainStationRent = 25;

    ///Attributes
    public TrainStationLot lot;

    ///Constructors
    public TrainStationTile(String name)
    {

        this.tileName = name;
        this.rent = trainStationRent;
    }

    ///Methods
    public void SetParent(TrainStationLot parent) {
        lot = parent;
    }

    @Override
    public void ApplyOnPassBy(Player player) {
        //DO NOTHING
    }

    @Override
    public void ApplyOnStop(Player player) {
        if (!this.IsFree()){
            //Make the player pay the tax
            int tax = this.rent * this.rentMultiplier;
            player.TransferMoney(tax, this.owner);
        }
        else
            this.BuyRoutine(player);
    }
}
