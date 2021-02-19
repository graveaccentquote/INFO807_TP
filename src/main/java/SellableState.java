public abstract class SellableState extends PropertyState {
    public SellableState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void sell(Player player) {
        if(player == null){
            tile.owner.receiveMoney(tile.GetSellingPrice());
            tile.changeOwnership(null);
            tile.SetState(new FreeState(tile));
        } else {
            if(player.canAfford(tile.GetSellingPrice())){
                player.transferMoney(tile.GetSellingPrice(), tile.owner);
                tile.changeOwnership(player);
            }
        }
    }
}
