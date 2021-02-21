import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PublicServiceLot extends BuyableLot {

    ///Attributes
    private final int lowMultiplier = 4;
    private final int highMultiplier = 10;

    //List of children of this lot
    private List<PublicServiceTile> children = new ArrayList<PublicServiceTile> ();

    ///Constructors
    public PublicServiceLot() {} //Default constructor

    public PublicServiceLot(ArrayList<PublicServiceTile> publicServiceTiles)
    {
        for (PublicServiceTile publicServiceTile : publicServiceTiles)
        {
            this.children.add(publicServiceTile);
            publicServiceTile.setParent(this);
        }
    }

    @Override
    public void onOwnershipChange() {
        HashMap<Player, Integer> map = new HashMap<Player, Integer>();
        Player owner;

        for (PublicServiceTile publicServiceTile : children)
        {
            owner = publicServiceTile.getOwner();
            if (map.containsKey(owner) )
                map.put(owner, highMultiplier);
            else
                map.put(owner, lowMultiplier);
        }

        for (PublicServiceTile publicServiceTile : children)
        {
            owner = publicServiceTile.getOwner();
            publicServiceTile.setRentMultiplier(map.get(owner));
        }
    }

    @Override
    public void addChild(BuyableTile child) {
        this.children.add((PublicServiceTile) child);
        child.setParent(this);
    }
}
