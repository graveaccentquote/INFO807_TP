import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private final int startingMoney = 1500;

    private String playerName;

    private int money = 0;

    private List<BuyableTile> ownedTiles = new ArrayList<BuyableTile> ();

    private MonopolyGame game;

    private DiceCup diceCup;

    public Player(MonopolyGame game, String playerName)
    {
        this.playerName = playerName;
        money = startingMoney;
        diceCup = new DiceCup();
        this.game = game;
    }

    public void playTurn() {
        System.out.println("--" + playerName +"'s turn --");
        System.out.println("Balance : "+money+"$");
        playOneRoll();
        while (canPlayAgain()){
            System.out.println(playerName+" rolled a double and can play again !");
            playOneRoll();
        }
    }
    private void playOneRoll(){
        int distance = rollDiceRoutine();
        System.out.println("Rolled "+distance);
        game.movePlayer(distance);
        constructionRoutine();
    }

    public boolean canAfford(int amount) {
        return money>=amount;
    }

    public void debit(int amount) {
        money-=amount;
    }

    public boolean displayBuyingStatus(BuyableTile tile) {
        //TODO
        return false;
    }

    public boolean displayBuyingProposition(BuyableTile tile) {
        System.out.println("Do you want to buy this tile ? [y/n]");
        System.out.println(tile.toString());
        Scanner input = new Scanner( System.in );
        return input.nextLine().toLowerCase().startsWith("y");
    }

    public int rollDiceRoutine() {
        diceCup.rollDice();
        return diceCup.getSum();
    }

    public void addOwnedTile(BuyableTile tile){
        this.ownedTiles.add(tile);
    }

    public void removeOwnedTile(BuyableTile tile){
        this.ownedTiles.remove(tile);
    }

    private void constructionRoutine() {
        displayOwnedProperties();
        PropertyTile t = getPropertyChoice();
        if(t!= null){
            t.build();
        }
    }

    private boolean canPlayAgain() {
        return diceCup.checkDouble();
    }

    private void displayOwnedProperties() {
        System.out.println("Current player's properties :");
        ArrayList<PropertyTile> properties = getOwnedProperties();
        for(int i=0;i<properties.size();i++){
            PropertyTile t = properties.get(i);
            System.out.println(i+") "+t.toBuildInfoString());
        }
    }

    private PropertyTile getPropertyChoice(){
        Scanner input = new Scanner( System.in );
        System.out.println("Which property do you want to build on ?");
        System.out.println("Type -1 to build on none.");
        ArrayList<PropertyTile> ownedProperties = getOwnedProperties();
        int p = input.nextInt();
        if(p<0 || p>=ownedProperties.size()){
            return null;
        } else {
            return ownedProperties.get(p);
        }
    }

    private ArrayList<PropertyTile> getOwnedProperties(){
        ArrayList<PropertyTile> res = new ArrayList<PropertyTile>();
        for(BuyableTile tile : ownedTiles){
            if(tile instanceof PropertyTile){
                res.add((PropertyTile) tile);
            }
        }
        return res;
    }

    public void transferMoney(int amount, Player player) {
        this.debit(amount);
        player.receiveMoney(amount);
    }

    public void receiveMoney(int amount) {
        money+= amount;
    }

    public int getMoney() {
        return money;
    }

    public int getDiceSum() {
        return diceCup.getSum();
    }

    public String toString()
    {
        return this.playerName;
    }
}
