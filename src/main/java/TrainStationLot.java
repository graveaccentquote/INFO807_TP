import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainStationLot extends BuyableLot {

    ///Attributes
    //List of children
    private ArrayList<TrainStationTile> children = new ArrayList<TrainStationTile>();

    ///Constructors

    public TrainStationLot() {} //Default constructor

    public TrainStationLot(ArrayList<TrainStationTile> trainStations)
    {
        for (TrainStationTile trainStation : trainStations)
        {
            children.add(trainStation);
            trainStation.setParent(this);
        }
    }

    @Override
    public void onOwnershipChange() {
        HashMap<Player, Integer> map = new HashMap<Player, Integer>();
        Player owner;

        for (TrainStationTile stationTile : children)
        {
            owner = stationTile.getOwner();
            if (map.containsKey(owner) )
                map.put(owner, map.get(owner) + 1);
            else
                map.put(owner, 1);
        }

        for (TrainStationTile stationTile : children)
        {
            owner = stationTile.getOwner();
            stationTile.setRentMultiplier(map.get(owner));
        }
    }

    @Override
    public void addChild(BuyableTile child) {
        this.children.add((TrainStationTile) child);
    }
}
