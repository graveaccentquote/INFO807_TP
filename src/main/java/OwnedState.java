public class OwnedState extends SellableState {
    public OwnedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void OnOwnershipChange(Player player) {

    }

    @Override
    public void Build() {

    }

    @Override
    public void SellBuilding() {

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
