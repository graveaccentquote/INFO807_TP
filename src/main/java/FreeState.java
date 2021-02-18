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
        // Can't be selled if already free
    }

    @Override
    public void Build() {
        // Can't be built on if free
    }

    @Override
    public void SellBuilding() {
        // Doesn't have any building when free
    }

    @Override
    public void ApplyOnStop(Player player) {
        // TODO buying proposition ?
    }
}
