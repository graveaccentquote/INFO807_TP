public class OwnedState extends SellableState {
    public OwnedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {
        // There isn't anything to do when the ownership changes in this state
    }

    @Override
    public void build() {
        // Can't build in this state (owner doesn't own every property of the lot)
    }

    @Override
    public void sellBuilding() {
        // Can't sell a building in this state
    }

    @Override
    public void applyOnStop(Player player) {
        tile.applyRent(player);
    }
}
