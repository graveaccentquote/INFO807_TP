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
    public void applyOnStop(Player player) {
        //DO NOTHING
    }

    public void applyOnPassBy(Player player) {
        System.out.println(player + " passed by the start tile and received a "+salary+"$ salary.");
        player.receiveMoney(this.salary);
    }

}
