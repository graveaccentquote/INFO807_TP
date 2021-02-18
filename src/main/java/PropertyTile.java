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

    public void Build() {
        state.Build();
    }

    public void BecomeConstructible() {
    }

    public void BecomeUnconstructible() {
    }

    public void SellBuilding() {
        state.SellBuilding();
    }

    @Override
    public void ApplyOnStop(Player player) {
        state.ApplyOnStop(player);
    }

    @Override
    public void ApplyOnPassBy(Player player) {
        //TODO
    }
}
