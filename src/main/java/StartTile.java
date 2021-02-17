public class StartTile extends Tile {


    ///Attributes
    //The salary given to any player passing by this Tile
    final private int salary;

    ///Constructors
    public StartTile(){
        this.tileName = "Start Tile";
        this.salary = 1000;
    }

    ///Methods
    public void ApplyOnStop(Player player) {
        //DO NOTHING
    }

    public void ApplyOnPassBy(Player player) {
        player.ReceiveMoney(this.salary);
    }

}
