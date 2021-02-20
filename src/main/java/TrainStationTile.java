public class TrainStationTile extends BuyableTile {

    private final int trainStationRent = 25;

    ///Attributes
    public TrainStationLot lot;

    ///Constructors
    public TrainStationTile(String name, int buyingCost)
    {
        this.tileName = name;
        this.rent = trainStationRent;
        this.cost = buyingCost;
    }

    public TrainStationTile(String name, int buyingCost, TrainStationLot parent)
    {
        this.tileName = name;
        this.rent = trainStationRent;
        this.cost = buyingCost;
        this.lot = parent;
        parent.addChild(this);
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

            System.out.println(player+" landed on the "+tileName+" train station and must pay "+tax+"$ to the owner ("+owner+")");
            int oldS = owner.getMoney();
            int oldB = player.getMoney();

            player.transferMoney(tax, this.owner);

            int newS = owner.getMoney();
            int newB = player.getMoney();
            System.out.println(owner.toString() +" "+oldS+"$ -> "+newS+"$");
            System.out.println(player.toString() +" "+oldB+"$ -> "+newB+"$");
        }
        else
            this.buyRoutine(player);
    }

    @Override
    public String toString() {
        return "Train station "+tileName+" [buying price : "+cost+"$, base rent : "+rent+"$]";
    }
}
