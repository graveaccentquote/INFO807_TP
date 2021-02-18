public class ConstructedState extends PropertyState {
    public ConstructedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void OnOwnershipChange(Player player) {

    }

    @Override
    public void Sell(Player player) {

    }

    @Override
    public void Build() {
        int count = tile.GetBuildingCount();
        if(count==4){
            tile.SetState(new FullyConstructedState(tile));
        }
    }

    @Override
    public void SellBuilding() {
        int count = tile.GetBuildingCount();
        if(count==1){
            tile.SetState(new ConstructibleState(tile));
        }
    }

    @Override
    public void ApplyOnStop(Player player) {

    }
}
