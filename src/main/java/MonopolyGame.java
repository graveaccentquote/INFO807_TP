import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class MonopolyGame {


    ///Attributes
    public Player currentPlayer;

    public Board board;

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

    ///Methods
    public void StartGame() {
        //Randomize the first player :
        Random rng = new Random();

        currentPlayer = players.get(rng.nextInt() % players.size());

        currentPlayer.PlayTurn();
    }

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

}
