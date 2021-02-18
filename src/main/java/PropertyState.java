public abstract class PropertyState {
    protected PropertyTile tile;

    public PropertyState(PropertyTile tile){
        this.tile = tile;
    }

    public abstract void OnOwnershipChange(Player player);

    public abstract void Sell(Player player);

    public abstract void Build();

    public abstract void SellBuilding();

    public abstract void ApplyOnStop(Player player);

}
