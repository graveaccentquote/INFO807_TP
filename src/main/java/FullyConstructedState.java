public class FullyConstructedState extends PropertyState {
    public FullyConstructedState(PropertyTile tile) {
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

    }

    @Override
    public void SellBuilding() {
        tile.SetState(new ConstructedState(tile));
    }

    @Override
    public void ApplyOnStop(Player player) {

    }
}
