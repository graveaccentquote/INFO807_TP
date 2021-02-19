import java.util.ArrayList;
import java.util.List;

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
        if(children.size()>0){
            int max, min;
            max = min = children.get(0).getBuildingCount();
            for(PropertyTile p : children){
                int count = p.getBuildingCount();
                max = Math.max(count, max);
                min = Math.min(count, min);
            }
            minBuildingCount = min;
            if(max == min){
                maxBuildingCount = max+1;
            } else {
                maxBuildingCount = max;
            }
        }
    }

    // Checks if a number of existing buildings on a tile
    // allows the owner to build more buildings on it
    public boolean isValidBuildingCount(int buildingCount) {
        return buildingCount<maxBuildingCount;
    }

    @Override
    public void onOwnershipChange() {
        boolean isConstructable = true;
        if(children.size()>0){
            Player owner = children.get(0).getOwner();
            if(owner!=null){
                int i = 1;
                while(i<children.size() && isConstructable){
                    if(children.get(i).getOwner() != owner){
                        isConstructable = false;
                    }
                    i++;
                }
            } else {
                isConstructable = false;
            }
        }

        if(isConstructable){
            for(PropertyTile t : children){
                t.becomeConstructible();
            }
        } else {
            for(PropertyTile t : children){
                t.becomeUnconstructible();
            }
        }
    }

    @Override
    public void addChild(BuyableTile child) {
        this.children.add((PropertyTile) child);
        child.setParent(this);
    }
}
