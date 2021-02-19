public class FreeState extends PropertyState {
    public FreeState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {
        tile.setState(new OwnedState(tile));
    }

    @Override
    public void sell(Player player) {
        // Can't be selled if already free
    }

    @Override
    public void build() {
        // Can't be built on if free
    }

    @Override
    public void sellBuilding() {
        // Doesn't have any building when free
    }

    @Override
    public void applyOnStop(Player player) {
        // TODO buying proposition ?
    }
}
