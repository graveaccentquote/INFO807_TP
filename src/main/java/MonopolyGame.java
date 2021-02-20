import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class MonopolyGame {


    ///Attributes
    private Player currentPlayer;

    private Board board;

    private ArrayList<Player> players = new ArrayList<Player> ();

    ///Constructors
    public MonopolyGame (String fileName)
    {
        this.parseJSON(fileName);
        this.board = new Board(fileName, players);
    }

    ///Main
    public static void main(String[] args)
    {

        /* Demo game setup : */
        MonopolyGame game = new MonopolyGame("./demoGameSetup.json");

        /* Regular game setup : */
        //MonopolyGame game = new MonopolyGame("./demoGameSetup.json");


        game.startGame();
    }

    ///Methods
    public void startGame() {
        //Randomize the first player :
        Random rng = new Random();
        int index = 0;
        /*int index = rng.nextInt() % players.size();
        if(index<0) index+= players.size();*/
        currentPlayer = players.get(index);
        while(true){
            currentPlayer.playTurn();
            index = (index+1)%players.size();
            currentPlayer = players.get(index);
        }
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
                System.err.println("Error in JSON file trying to read player names");
                throw new Exception();
            }

            for (Object name : playerNamesList)
                this.players.add(new Player(this, (String) name));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
