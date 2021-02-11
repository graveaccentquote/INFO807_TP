import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("9bd1b11d-fadb-439c-b167-6bcda96f35e2")
public class Board {
    @objid ("6492fe3d-7527-46e9-88d4-c6907c6921e1")
    private HashMap<Player, integer> playerPositions;

    @objid ("c0bf46ef-f2b1-475e-b405-6fe875475f1c")
    public List<Tile> tiles = new ArrayList<Tile> ();

    @objid ("dabbef4e-3794-4b18-ae7f-04180ed118e0")
    public void MovePlayer(Player player, int tileCount) {
    }

}
