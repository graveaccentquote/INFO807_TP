public class OwnedState extends SellableState {
    public OwnedState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void onOwnershipChange(Player player) {
        // There isn't anything to do when the ownership changes in this state
    }

    @Override
    public void build() {
        // Can't build in this state (owner doesn't own every property of the lot)
        System.out.println(tile.owner+" doesn't own every property in the "+tile.getLot().getLotName()+" lot, therefore can't build on this property yet");
    }

    @Override
    public void sellBuilding() {
        // There aren't any building to sell in this state
    }

    @Override
    public void applyOnStop(Player player) {
        tile.applyRent(player);
    }
}
