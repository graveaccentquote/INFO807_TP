import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Player;
import Board;


@objid ("8c91ecaf-394b-446c-bee2-426ab6f7efb0")
public class MonopolyGame {


    ///Attributes
    @objid ("b49c790e-42f8-4e63-807e-876b76caf57e")
    public Player currentPlayer;

    @objid ("f96577da-92cc-4b3e-b561-6b11215d5943")
    public Board board;

    @objid ("fc0ee026-8ff8-47f6-9f6f-6f1d18546a2d")
    public ArrayList<Player> players = new ArrayList<Player> ();

    ///Constructors
    public MonopolyGame ()
    {
        Player Tom = new Player("Tom");
        Player Hugo = new Player("Hugo");
        Player Theo = new Player("Theo");

        players.add(Tom);
        players.add(Hugo);
        players.add(Theo);

        board = new Board(players);
    }

    public MonopolyGame (String filepath)
    {
        this.parseJSON();
    }

    ///Main
    public static void main(String[] args)
    {
        MonopolyGame game = new MonopolyGame("test");
    }
}

    ///Methods
    @objid ("242a0e32-2682-45b3-abef-5325a2bca463")
    public void StartGame() {
        //Randomize the first player :
        Random rng = new Random();

        currentPlayer = players.get(rd.nextInt() % players.size());

        currentPlayer.playTurn();
    }

    @objid ("f6446150-23b9-4458-bacd-3fd320554b02")
    public void MovePlayer(int tileCount) {
        board.MovePlayer(currentPlayer, tileCount);
    }

    private void parseJSON()
    {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("./boardSetup.json"));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray playerNamesList = (JSONArray) jsonObject.get("PlayerNames");

            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            Iterator<JSONObject> iterator = playerNamesList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
    }

}
