public class LuxuryTaxTile extends Tile {

    ///Attributes
    private final int flatTax = 75;

    ///Constructors
    public LuxuryTaxTile()
    {
        this.tileName = "LUXURY TAX";
    }

    ///Methods
    public void ApplyOnStop(Player player) {
        player.Debit(this.flatTax);
    }

    public void ApplyOnPassBy(Player player) {
        //DO NOTHING
    }

}
