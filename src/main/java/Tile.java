public abstract class Tile {

    protected String tileName;

    ///Methods
    public abstract void applyOnStop(Player player);

    public abstract void applyOnPassBy(Player player);

    public String getTileName()
    {
        return this.tileName;
    }

}
