public class IncomeTaxTile extends Tile {
    ///Attributes
    private final int minTax = 200;
    private final double taxRatio = 0.1;


    ///Constructors
    public IncomeTaxTile()
    {
        this.tileName = "Income Tax Tile";
    }


    ///Methods
    @Override
    public void ApplyOnStop(Player player) {
        //Pay taxRatio * money or minTax, whichever is greater
        double tax = player.GetMoney() * this.taxRatio;
        player.Debit(max(minTax, tax));
    }

    @Override
    public void ApplyOnPassBy(Player player) {
        //DO NOTHING
    }
}
