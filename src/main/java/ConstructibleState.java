public class ConstructibleState extends SellableState {
    public ConstructibleState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {

    }

    @Override
    public void build() {
        tile.SetState(new ConstructedState(tile));
    }

    @Override
    public void sellBuilding() {

    }

    @Override
    public void applyOnStop(Player player) {

    }
}
