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
        int count = tile.GetBuildingCount();
        if(count==4){
            tile.SetState(new FullyConstructedState(tile));
        }
    }

    @Override
    public void sellBuilding() {
        int count = tile.GetBuildingCount();
        if(count==1){
            tile.SetState(new ConstructibleState(tile));
        }
    }

    @Override
    public void applyOnStop(Player player) {

    }
}
