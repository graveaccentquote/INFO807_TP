public class FreeState extends PropertyState {
    public FreeState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void OnOwnershipChange(Player player) {
        tile.SetState(new OwnedState(tile));
    }

    @Override
    public void Sell(Player player) {

    }

    @Override
    public void Build() {

    }

    @Override
    public void SellBuilding() {

    }

    @Override
    public void ApplyOnStop(Player player) {

    }
}
