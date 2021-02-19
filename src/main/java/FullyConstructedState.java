public class FullyConstructedState extends PropertyState {
    public FullyConstructedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {
        // ownership can't change in this state
    }

    @Override
    public void sell(Player player) {
        // Can't be sold if there are buildings left on the property
    }

    @Override
    public void build() {

    }

    @Override
    public void sellBuilding() {
        tile.setState(new ConstructedState(tile));
    }

    @Override
    public void applyOnStop(Player player) {
        tile.applyRent(player);
    }
}
