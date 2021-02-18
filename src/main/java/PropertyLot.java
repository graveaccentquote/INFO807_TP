import java.util.ArrayList;
import java.util.List;

public class PropertyLot extends BuyableLot {
    public int maxBuildingCount;

    public int minBuildingCount;

    public List<PropertyTile> children = new ArrayList<PropertyTile> ();

    public void OnBuildEvent() {
    }

    public boolean IsValidBuildingCount(int buildingCount) {
        return false; //TODO
    }

    @Override
    public void OnOwnershipChange() {

    }
}
