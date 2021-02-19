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
    }

    public void becomeUnconstructible() {
        setState(new OwnedState(this));
    }

    public void sell(Player player){
        state.sell(player);
    }

    public void sellBuilding() {
        state.sellBuilding();
    }

    public int getBuildingCount() {
        return buildingCount;
    }

    @Override
    public void applyOnStop(Player player) {
        state.applyOnStop(player);
    }

    @Override
    public void applyOnPassBy(Player player) {
        //There isn't anything to do when the player passes on a property tile
    }

    @Override
    protected void changeOwnership(Player player) {
        super.changeOwnership(player);
        state.onOwnershipChange(player);
    }

    public String toString(){
        return this.tileName
                + " ["
                + this.cost
                + " / "
                + this.buildingCost
                + "] "
                + Arrays.toString(this.buildingRents);
    }
}
