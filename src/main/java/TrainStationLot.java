import java.util.ArrayList;
import java.util.List;

public class TrainStationLot extends BuyableLot {

    ///Attributes
    //List of children
    private ArrayList<TrainStationTile> children = new ArrayList<TrainStationTile>();

    ///Constructors
    public TrainStationLot(ArrayList<TrainStationTile> trainStations)
    {
        for (TrainStationTile trainStation : trainStations)
        {
            children.add(trainStation);
            trainStation.SetParent(this);
        }
    }

    @Override
    public void onOwnershipChange() {
        //TODO
    }
}
