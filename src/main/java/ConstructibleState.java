public class ConstructibleState extends SellableState {
    public ConstructibleState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {
        // There isn't anything to do when the ownership changes in this state
    }

    @Override
    public void build() {
        tile.setState(new ConstructedState(tile));
        // no need to check if the building count is valid, in this state the building count is always 0
        tile.addBuilding();
    }

    @Override
    public void sellBuilding() {
        // Doesn't have any building when constructible
    }

    @Override
    public void applyOnStop(Player player) {
        tile.applyRent(player);
    }
}
