import java.util.ArrayList;
import java.util.List;

public class PropertyLot extends BuyableLot {

    ///Attributes
    public int maxBuildingCount;
    public int minBuildingCount;

    //List of children of this lot
    public List<PropertyTile> children = new ArrayList<PropertyTile> ();

    ///Constructors
    public PropertyLot(){} //Default constructor

    ///Methods
    public void onBuildEvent() {
    }

    public boolean isValidBuildingCount(int buildingCount) {
        return false; //TODO
    }

    @Override
    public void onOwnershipChange() {

    }

    @Override
    public void addChild(BuyableTile child) {
        this.children.add((PropertyTile) child);
    }
}
