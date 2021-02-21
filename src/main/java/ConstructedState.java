public class ConstructedState extends PropertyState {
    public ConstructedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {
        // ownership can't change in the constructed state
    }

    @Override
    public void sell(Player player) {
        // Can't be sold if there are buildings left on a property
    }

    @Override
    public void build() {
        int count = tile.getBuildingCount();
        if(tile.getLot().isValidBuildingCount(count)){
            if(count==4 && tile.addBuilding()){
                tile.setState(new FullyConstructedState(tile));
            }
        } else {
            System.out.println("There can't be more buildings on this property without building on the other properties of the lot first");
        }
    }

    @Override
    public void sellBuilding() {
        int count = tile.getBuildingCount();
        if(count==1){
            tile.setState(new ConstructibleState(tile));
        }
        tile.sellOneBuilding();
    }

    @Override
    public void applyOnStop(Player player) {
        tile.applyRent(player);
    }
}
