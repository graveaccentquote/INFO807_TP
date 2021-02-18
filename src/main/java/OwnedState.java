public class OwnedState extends SellableState {
    public OwnedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void OnOwnershipChange(Player player) {
        // Nothing to do in this state
    }

    @Override
    public void Build() {
        // Can't build in this state
    }

    @Override
    public void SellBuilding() {
        // Can't sell a building in this state
    }

    @Override
    public void ApplyOnStop(Player player) {
        int rentCost = tile.GetRentCost();
        if(player.CanAfford(rentCost)){
            player.TransferMoney(rentCost, player);
        } else {
            // TODO player loses the game
        }
    }
}
