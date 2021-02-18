import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

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
        PublicServiceLot publicServiceLot = new PublicServiceLot();
        TrainStationLot trainStationLot = new TrainStationLot();
        PropertyLot lot;
        int buyingCost;
        int buildingCost;
        int[] rents = new int[6];

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName));

            JSONObject jsonObject = (JSONObject) obj;
            JSONObject board = (JSONObject) jsonObject.get("board");


            //Parse the property Lots
            JSONArray propertyLots = (JSONArray) board.get("propertyLots");

            if (propertyLots == null)
            {
                System.err.println("Error in JSON file trying to read propertyLots");
                throw new Exception();
            }

            HashMap<String, PropertyLot> propertyLotHashMap = new HashMap<String, PropertyLot>();

            for (Object lotName : propertyLots)
                propertyLotHashMap.put((String) lotName, new PropertyLot());

            //Parse the tiles
            JSONArray tilesArray = (JSONArray) board.get("tiles");

            if (tiles == null)
            {
                System.err.println("Error in JSON file trying to read tiles");
                throw new Exception();
            }

            for (Object element : tilesArray)
            {
                JSONObject tile = (JSONObject) element;
                String type = (String) tile.get("type");
                String name = (String) tile.get("name");

                //Create a new tile depending on type
                switch (type)
                {
                    case "StartTile":
                        this.tiles.add(new StartTile());
                        break;
                    case "PropertyTile":
                        String lotName = (String) tile.get("parent");
                        buyingCost = Integer.parseInt((String) tile.get("buyingCost") );
                        buildingCost = Integer.parseInt((String) tile.get("constructionCost"));
                        JSONArray rentsArray = (JSONArray) tile.get("rents");

                        for (int i=0; i<rentsArray.size(); ++i)
                            rents[i] = Integer.parseInt((String) rentsArray.get(i));

                        lot = propertyLotHashMap.get(lotName);
                        this.tiles.add(new PropertyTile(name, lot, buyingCost, buildingCost, rents));
                        break;
                    case "TrainStationTile":
                        buyingCost = Integer.parseInt((String) tile.get("buyingCost") );
                        this.tiles.add(new TrainStationTile(name, buyingCost, trainStationLot));
                        break;
                    case "PublicServiceTile":
                        buyingCost = Integer.parseInt((String) tile.get("buyingCost") );
                        this.tiles.add(new PublicServiceTile(name, buyingCost, publicServiceLot));
                        break;
                    case "DrawCardTile":
                        this.tiles.add(new DrawCardTile(name));
                        break;
                    case "LuxuryTaxTile":
                        this.tiles.add(new LuxuryTaxTile());
                        break;
                    case "IncomeTaxTile":
                        this.tiles.add(new IncomeTaxTile());
                        break;
                    case "GoToJailTile":
                        this.tiles.add(new GoToJailTile());
                        break;
                    case "ParkTile":
                        this.tiles.add(new ParkTile());
                        break;
                    case "JailTile":
                        this.tiles.add(new PrisonTile());
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            acc.append("Tile index : ");
            acc.append(i);
            acc.append(" - ");
            acc.append(this.tiles.get(i).toString());
            acc.append("\n");
        }

        return acc.toString();
    }

}
