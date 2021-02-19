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
        SetState(new FreeState(this));
    }

    public void SetState(PropertyState state){
        this.state = state;
    }

    public void build() {
        state.build();
    }

    public void becomeConstructible() {
    }

    public void becomeUnconstructible() {
    }

    public void sell(Player player){
        state.sell(player);
    }

    public void sellBuilding() {
        state.sellBuilding();
    }

    @Override
    public void applyOnStop(Player player) {
        state.applyOnStop(player);
    }

    @Override
    public void applyOnPassBy(Player player) {
        //TODO
    }

    @Override
    protected void changeOwnership(Player player) {
        super.changeOwnership(player);
        state.onOwnershipChange(player);
    }

    public int GetBuildingCount() {
        return buildingCount;
    }

    public void SetBuildingCount(int count) {
        buildingCount = count;
    }

    public int GetSellingPrice(){
        return cost/2;
    }

    public int GetRentCost(){
        int baseRent = rent * rentMultiplier;
        int buildingRent = buildingRents[buildingCount]; // TODO 0 buildings ?
        return  baseRent + buildingRent;
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
