public class OwnedState extends SellableState {
    public OwnedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {
        // Nothing to do in this state
    }

    @Override
    public void build() {
        // Can't build in this state
    }

    @Override
    public void sellBuilding() {
        // Can't sell a building in this state
    }

    @Override
    public void applyOnStop(Player player) {
        int rentCost = 0;//TODO
        if(player.canAfford(rentCost)){
            player.transferMoney(rentCost, player);
        } else {
            // TODO player loses the game
        }
    }
}
