import java.util.ArrayList;
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
        //TODO
    }

    @Override
    public void addChild(BuyableTile child) {
        this.children.add((TrainStationTile) child);
    }
}
