public class LuxuryTaxTile extends Tile {

    ///Attributes
    private final int flatTax = 75;

    ///Constructors
    public LuxuryTaxTile()
    {
        this.tileName = "LUXURY TAX";
    }

    ///Methods
    public void applyOnStop(Player player) {
        player.debit(this.flatTax);
    }

    public void applyOnPassBy(Player player) {
        //DO NOTHING
    }

}
