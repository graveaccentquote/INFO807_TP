public abstract class Tile {

    public String tileName;

    ///Methods
    public abstract void ApplyOnStop(Player player);

    public abstract void ApplyOnPassBy(Player player);

    public String getTileName()
    {
        return this.tileName;
    }

}
