public abstract class SellableState extends PropertyState {
    public SellableState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void Sell(Player player) {
        if(player == null){
            tile.SetState(new FreeState(tile));
        }
    }
}
