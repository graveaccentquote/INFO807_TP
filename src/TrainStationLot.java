import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

import TrainStationTile;
import BuyableTile;

@objid ("8292c46e-a0e9-462d-a1bc-44c5c0850e3e")
public class TrainStationLot extends BuyableLot {

    ///Attributes
    @objid ("90465071-cfd8-48c4-bdbf-89dae4964bea")
    //List of children
    private ArrayList<BuyableTile> children = new ArrayList<TrainStationTile>(); //TODO : change to TrainStationTile

    ///Constructors
    public TrainStationLot(ArrayList<TrainStationTile> trainStations)
    {
        for (TrainStationTile trainStation : trainStations)
        {
            children.add(trainStation);
            trainStation.setParent(this);
        }
    }
}
