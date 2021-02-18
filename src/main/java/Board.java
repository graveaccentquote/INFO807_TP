import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    ///Attributes
    //Map of players and the index of the Tile they're on
    private HashMap<Player, Integer> playerPositions;

    //Circular list of Tiles
    private List<Tile> tiles = new ArrayList<Tile> ();

    ///Constructors
    public Board(ArrayList<Player> players)
    {
        for (Player player : players)
            playerPositions.put(player, 0);

        this.createTileArrangement();
    }

    ///Methods
    public void MovePlayer(Player player, int tileCount) {

        Integer index = playerPositions.get(player);
        int size = this.tiles.size();

        //Do passby actions
        for (int i=1; i<=tileCount; ++i)
        {
            tiles.get((index + i) % size).ApplyOnPassBy(player);
        }

        int newIndex = (index + tileCount) % size;

        //Do stop action
        tiles.get(newIndex).ApplyOnStop(player);

        //Update player position
        this.playerPositions.put(player, newIndex);
    }

    //Hardcoded version of tile arrangement
    private void createTileArrangement()
    {
        //TODO
    }

}
