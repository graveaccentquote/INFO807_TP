public abstract class SellableState extends PropertyState {
    public SellableState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void Sell(Player player) {
        if(player == null){
            tile.owner.ReceiveMoney(tile.GetSellingPrice());
            tile.ChangeOwnership(null);
            tile.SetState(new FreeState(tile));
        } else {
            if(player.CanAfford(tile.GetSellingPrice())){
                player.TransferMoney(tile.GetSellingPrice(), tile.owner);
                tile.ChangeOwnership(player);
            }
        }
    }
}
