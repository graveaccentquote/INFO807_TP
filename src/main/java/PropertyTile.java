import java.util.Arrays;

public class PropertyTile extends BuyableTile {
    private int buildingCount;

    private int[] buildingRents = new int[6];

    private int buildingCost;

    public PropertyLot lot;

    private PropertyState state;

    public PropertyTile(String name, PropertyLot lot, int buyingCost, int buildingCost, int[] buildingRents){
        this.cost = buyingCost;
        this.buildingCost = buildingCost;
        this.lot = lot;
        buildingCount = 0;
        tileName = name;
        //Initial state
        lot.addChild(this);
        System.arraycopy(buildingRents, 0, this.buildingRents, 0, buildingRents.length);
        setState(new FreeState(this));
    }

    public void setState(PropertyState state){
        this.state = state;
    }

    public void build() {
        state.build();
    }

    public void becomeConstructible() {
        setState(new ConstructibleState(this));
        this.rentMultiplier = 2;
    }

    public void becomeUnconstructible() {
        if(getOwner()!=null){
            setState(new OwnedState(this));
        }
        this.rentMultiplier = 1;
    }

    @Override
    public void sell(Player player){
        state.sell(player);
    }

    public void sellBuilding() {
        state.sellBuilding();
    }

    public int getBuildingCount() {
        return buildingCount;
    }

    public int getSellingPrice() {
        return buildingRents[0];
    }

    public void addBuilding() {
        if(owner.canAfford(buildingCost)){
            owner.debit(buildingCost);
            buildingCount++;
            lot.onBuildEvent();
        }
    }

    public void sellOneBuilding() {
        buildingCount--;
        owner.receiveMoney(buildingCost/2);
        lot.onBuildEvent();
    }

    @Override
    public void applyOnStop(Player player) {
        state.applyOnStop(player);
    }

    @Override
    public void applyOnPassBy(Player player) {
        //There isn't anything to do when the player passes by a property tile
    }

    @Override
    protected void changeOwnership(Player player) {
        super.changeOwnership(player);
        state.onOwnershipChange(player);
    }

    public String toBuildInfoString(){
        return "("+lot.lotName+")"+ tileName +" ["+getBuildingCount()+" buildings, "+buildingCost+"$ per building]";
    }

    public String toString(){
        return  "("
                +lot.lotName
                +")"
                + this.tileName
                + " ["
                + this.cost
                + " / "
                + this.buildingCost
                + "] "
                + Arrays.toString(this.buildingRents);
    }

    public void applyRent(Player player) {
        int rentCost = (buildingRents[buildingCount])*rentMultiplier;

        System.out.println(player.toString() + " landed on "+owner+"'s property and must pay a "+rentCost+"$ rent");
        int oldS = owner.getMoney();
        int oldB = player.getMoney();

        player.transferMoney(rentCost, owner);

        int newS = owner.getMoney();
        int newB = player.getMoney();
        System.out.println(owner.toString() +" "+oldS+"$ -> "+newS+"$");
        System.out.println(player.toString() +" "+oldB+"$ -> "+newB+"$");
    }
}
