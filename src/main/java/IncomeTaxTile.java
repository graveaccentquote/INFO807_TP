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
    public void applyOnStop(Player player) {
        //Pay taxRatio * money or minTax, whichever is greater
        int tax = (int) Math.floor((player.getMoney() * this.taxRatio));
        player.debit(Math.max(minTax, tax));
    }

    @Override
    public void applyOnPassBy(Player player) {
        //DO NOTHING
    }
}
