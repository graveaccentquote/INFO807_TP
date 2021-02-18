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
    public void setParent(TrainStationLot parent) {
        lot = parent;
    }

    @Override
    public void applyOnPassBy(Player player) {
        //DO NOTHING
    }

    @Override
    public void applyOnStop(Player player) {
        if (!this.isFree()){
            //Make the player pay the tax
            int tax = this.rent * this.rentMultiplier;
            player.transferMoney(tax, this.owner);
        }
        else
            this.buyRoutine(player);
    }
}
