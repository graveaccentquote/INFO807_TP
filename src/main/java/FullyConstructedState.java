public class FullyConstructedState extends PropertyState {
    public FullyConstructedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {

    }

    @Override
    public void sell(Player player) {

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

    }
}
