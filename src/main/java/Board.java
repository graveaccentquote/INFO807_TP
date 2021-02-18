import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    ///Attributes
    //Map of players and the index of the Tile they're on
    private HashMap<Player, Integer> playerPositions = new HashMap<Player, Integer>();

    //Circular list of Tiles
    private List<Tile> tiles = new ArrayList<Tile> ();

    ///Constructors
    public Board(String fileName, ArrayList<Player> players)
    {
        //Parse the JSON file for tile arrangement
        this.createTileArrangement(fileName);

        //Put every player on the start tile
        for (Player player : players)
            playerPositions.put(player, 0);


        System.out.println(this.toString());
    }

    ///Methods
    public void movePlayer(Player player, int tileCount) {

        Integer index = playerPositions.get(player);
        int size = this.tiles.size();

        //Do pass-by actions
        for (int i=1; i<=tileCount; ++i)
        {
            tiles.get((index + i) % size).applyOnPassBy(player);
        }

        int newIndex = (index + tileCount) % size;

        //Do stop action
        tiles.get(newIndex).applyOnStop(player);

        //Update player position
        this.playerPositions.put(player, newIndex);
    }

    //Parse the JSON file for tile arrangement
    private void createTileArrangement(String fileName)
    {
        //TODO
    }

    public String toString()
    {
        StringBuilder acc = new StringBuilder("");

        for (Player o : playerPositions.keySet())
        {
            acc.append("Player ");
            acc.append(o.toString());
            acc.append(" is on index : ");
            acc.append(playerPositions.get(o));
            acc.append("\n");
        }

        for (int i = 0; i<this.tiles.size(); ++i)
        {
            acc.append("Tile index :");
            acc.append(i);
            acc.append(" - ");
            acc.append(this.tiles.get(i).toString());
            acc.append("\n");
        }

        return acc.toString();
    }

}
