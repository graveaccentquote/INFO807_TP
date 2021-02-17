import com.modeliosoft.modelio.javadesigner.annotations.objid;

import BuyableTile;

@objid ("c537a412-3507-4d5e-83e5-3107d22e828b")
public class TrainStationTile extends BuyableTile {

    private final int trainStationRent = 25;

    ///Attributes
    @objid ("9ec3af4f-3758-415d-9bb7-9da493bff370")
    public TrainStationLot lot;

    ///Constructors
    public TrainStationTile(String name)
    {

        this.tileName = name;
        this.rent = trainStationRent;
    }

    ///Methods
    public void SetParent(TrainStationLot parent) {
        lot = parent;
    }

    @Override
    public void ApplyOnPassBy(Player player) {
        //DO NOTHING
    }

    @Override
    public void ApplyOnStop(Player player) {
        if (!this.IsFree()){
            //Make the player pay the tax
            int tax = this.rent * this.rentMultiplier;
            player.TransferMoney(tax, this.owner);
        }
        else
            this.BuyRoutine(player);
    }
}
