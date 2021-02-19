import java.util.*;

public class PropertyLot extends BuyableLot {

    ///Attributes
    // Inclusive limits of the maximum buildings there can be on a single property of the lot
    public int maxBuildingCount;
    public int minBuildingCount;

    //List of children of this lot
    public List<PropertyTile> children = new ArrayList<PropertyTile> ();

    ///Constructors
    public PropertyLot(){
        minBuildingCount = 0;
        maxBuildingCount = 1;
    } //Default constructor

    ///Methods
    public void onBuildEvent() {
        ArrayList<Integer> buildingCounts = new ArrayList<Integer>();

        for (PropertyTile child : children)
            buildingCounts.add(child.getBuildingCount());
        try
        {
            minBuildingCount = Collections.min(buildingCounts);
            //The max is either max or max+1 if min==max
            maxBuildingCount = Math.max(Collections.max(buildingCounts), minBuildingCount+1);
        }
        catch (Exception e)
        {
            System.err.print("Error, trying to find buildingCount in empty list of children");
        }


    } // Checks if a number of existing buildings on a tile
    // allows the owner to build more buildings on it
    public boolean isValidBuildingCount(int buildingCount) {
        return buildingCount<maxBuildingCount;
    }

    @Override
    public void onOwnershipChange() {

        HashMap<Player, Integer> map = new HashMap<Player, Integer>();
        Player owner;

        for (PropertyTile propertyTile : children)
        {
            owner = propertyTile.getOwner();
            if (map.containsKey(owner) )
                map.put(owner, map.get(owner) + 1);
            else
                map.put(owner, 1);
        }

        //Compute the player with the max properties of this Lot
        Player p = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        if (p != null && map.get(p) == children.size())
            for (PropertyTile propertyTile : children)
                propertyTile.becomeConstructible();
        else
            for (PropertyTile propertyTile : children)
                propertyTile.becomeUnconstructible();
    }

    @Override
    public void addChild(BuyableTile child) {
        this.children.add((PropertyTile) child);
        child.setParent(this);
    }
}
