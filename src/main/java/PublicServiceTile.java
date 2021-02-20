public class PublicServiceTile extends BuyableTile {

    ///Attributes
    private PublicServiceLot lot;

    ///Constructors
    public PublicServiceTile(String name, int buyingCost)
    {
        this.tileName = name;
        this.cost = buyingCost;
    }

    public PublicServiceTile(String name, int buyingCost, PublicServiceLot parent)
    {
        this.tileName = name;
        this.cost = buyingCost;
        this.rent = buyingCost/10;
        this.lot = parent;
        parent.addChild(this);
    }

    ///Methods
    @Override
    public void applyOnPassBy(Player player) {
        //DO NOTHING
    }

    @Override
    public void applyOnStop(Player player) {
        if (!this.isFree())
        {
            //Make the player pay the tax
            int diceSum = player.getDiceSum();
            int tax = this.rent * this.rentMultiplier * diceSum;
            System.out.println(player+" landed on the "+tileName+" service, owned by "+owner);
            System.out.println(player+"'s last roll was "+diceSum+", they must pay "+rent*rentMultiplier+"*"+diceSum+"="+tax+"$ to the owner");
            int oldS = owner.getMoney();
            int oldB = player.getMoney();

            player.transferMoney(tax, this.owner);

            int newS = owner.getMoney();
            int newB = player.getMoney();
            System.out.println(owner.toString() +" "+oldS+"$ -> "+newS+"$");
            System.out.println(player.toString() +" "+oldB+"$ -> "+newB+"$");


            //Launch the buying status routine
            player.displayBuyingStatus(this);
        }
        else
            //Launch the BuyableTile buy routine
            this.buyRoutine(player);
    }

    @Override
    public String toString(){
        return "Public service "+tileName+" [buying price : "+cost+"$, base rent : "+rent+"$]";
    }
}
