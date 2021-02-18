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
        //Initial state
        SetState(new FreeState(this));
    }

    public void SetState(PropertyState state){
        this.state = state;
    }

    public void Build() {
        state.Build();
    }

    public void BecomeConstructible() {
        SetState(new ConstructibleState(this));
    }

    public void BecomeUnconstructible() {
        SetState(new OwnedState(this));
    }

    // Sells the property to a player
    public void Sell(Player player){
        state.Sell(player);
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

    @Override
    protected void ChangeOwnership(Player player) {
        super.ChangeOwnership(player);
        state.OnOwnershipChange(player);
    }

    public int GetBuildingCount() {
        return buildingCount;
    }

    public void SetBuildingCount(int count) {
        buildingCount = count;
    }
}
