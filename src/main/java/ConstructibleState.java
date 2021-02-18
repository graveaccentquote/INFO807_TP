public class ConstructibleState extends SellableState {
    public ConstructibleState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void OnOwnershipChange(Player player) {

    }

    @Override
    public void Build() {
        tile.SetState(new ConstructedState(tile));
    }

    @Override
    public void SellBuilding() {

    }

    @Override
    public void ApplyOnStop(Player player) {

    }
}
