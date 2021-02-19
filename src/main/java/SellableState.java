public abstract class SellableState extends PropertyState {
    public SellableState(PropertyTile tile) {
        super(tile);
    }

    @Override
    public void sell(Player player) {
        if(player == null){
            // TODO change ownership and transfer money
            tile.SetState(new FreeState(tile));
        } else {
            if(false){//TODO check if buyer can afford
                // TODO change ownership and transfer money
            }
        }
    }
}
