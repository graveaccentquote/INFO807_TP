public abstract class SellableState extends PropertyState {
    public SellableState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void sell(Player player) {
        int price = tile.getSellingPrice();
        if(player == null){
            tile.owner.receiveMoney(price);
            tile.changeOwnership(null);
            tile.setState(new FreeState(tile));
        } else {
            if(player.canAfford(price)){
                player.transferMoney(price, tile.owner);
                tile.changeOwnership(player);
            }
        }
    }
}
