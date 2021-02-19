public class ConstructedState extends PropertyState {
    public ConstructedState(PropertyTile tile) {
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
        int count = tile.getBuildingCount();
        if(count==4){
            tile.setState(new FullyConstructedState(tile));
        }
    }

    @Override
    public void sellBuilding() {
        int count = tile.getBuildingCount();
        if(count==1){
            tile.setState(new ConstructibleState(tile));
        }
    }

    @Override
    public void applyOnStop(Player player) {
        tile.applyRent(player);
    }
}
