import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("9bd1b11d-fadb-439c-b167-6bcda96f35e2")
public class Board {

    ///Attributes
    @objid ("6492fe3d-7527-46e9-88d4-c6907c6921e1")
    //Map of players and the index of the Tile they're on
    private HashMap<Player, Integer> playerPositions;

    //Circular list of Tiles
    @objid ("c0bf46ef-f2b1-475e-b405-6fe875475f1c")
    private List<Tile> tiles = new ArrayList<Tile> ();

    ///Constructors
    public Board(ArrayList<Player> players)
    {
        for (Player player : players)
            playerPositions.put(player, 0);

        this.createTileArrangement();
    }

    ///Methods
    @objid ("dabbef4e-3794-4b18-ae7f-04180ed118e0")
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
        tiles.get(newIndex).ApplyOnStop();

        //Update player position
        this.playerPositions.put(player, newIndex);
    }

    //Hardcoded version of tile arrangement
    private void createTileArrangement()
    {
        //TODO
    }

}
