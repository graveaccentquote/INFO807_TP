public abstract class PropertyState {
    protected PropertyTile tile;

    public PropertyState(PropertyTile tile){
        this.tile = tile;
    }

    public abstract void onOwnershipChange(Player player);

    public abstract void sell(Player player);

    public abstract void build();

    public abstract void sellBuilding();

    public abstract void applyOnStop(Player player);

}
