public class PropertyTile extends BuyableTile {
    private int buildingCount;

    private int[] buildingRents;

    private int buildingCost;

    public PropertyLot lot;

    private PropertyState state;

    public PropertyTile(String name, PropertyLot lot, int buyingCost, int buildingCost, int[] buildingRents){
        this.cost = buyingCost;
        this.buildingCost = buildingCost;
        this.buildingRents = buildingRents;
        this.lot = lot;
        buildingCount = 0;
        tileName = name;
        state = new FreeState();
    }

    public void build() {
        state.build();
    }

    public void becomeConstructible() {
    }

    public void becomeUnconstructible() {
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
}
