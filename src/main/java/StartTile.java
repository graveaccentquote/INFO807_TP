import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("43875cca-fa39-483a-8c96-e9eeb5055b73")
public class StartTile extends Tile {


    ///Attributes
    @objid ("e4521718-1b16-480b-8be9-c6372dc64640")
    //The salary given to any player passing by this Tile
    final private int salary;

    ///Constructors
    public StartTile(){
        this.tileName = "Start Tile";
        this.salary = 1000;
    }

    ///Methods
    @objid ("fe7b86ef-0209-4b8f-97a6-03bc3d7458a3")
    public void ApplyOnStop(Player player) {
        //DO NOTHING
    }

    @objid ("07e3602d-0136-42b3-9f4a-18122c7d2cbc")
    public void ApplyOnPassBy(Player player) {
        player.ReceiveMoney(this.salary);
    }

}
