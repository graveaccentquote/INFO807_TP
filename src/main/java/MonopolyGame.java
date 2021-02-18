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
    public MonopolyGame (String fileName)
    {
        this.parseJSON(fileName);
        this.board = new Board(fileName, players);
    }

    ///Main
    public static void main(String[] args)
    {
        MonopolyGame game = new MonopolyGame("./gameSetup.json");
    }

    ///Methods
    public void startGame() {
        //Randomize the first player :
        Random rng = new Random();

        currentPlayer = players.get(rng.nextInt() % players.size());

        currentPlayer.playTurn();
    }

    public void movePlayer(int tileCount) {
        board.movePlayer(currentPlayer, tileCount);
    }

    private void parseJSON(String fileName)
    {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(fileName));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray playerNamesList = (JSONArray) jsonObject.get("players");

            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.

            if (playerNamesList == null)
            {
                System.err.println("Error in JSON file");
                throw new Exception();
            }

            for (Object name : playerNamesList)
                this.players.add(new Player((String) name));

            for (Player player : this.players)
            {
                System.out.println("player : " + player.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
