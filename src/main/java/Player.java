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

    public Player(String playerName)
    {
        this.playerName = playerName;
        money = startingMoney;
    }

    public Player(int baseMoney){
        money = baseMoney;
    }

    public void playTurn() {
        do{
            int distance = rollDiceRoutine();
            game.movePlayer(distance);
        } while(canPlayAgain());
    }

    public boolean canAfford(int amount) {
        return money>=amount;
    }

    public void debit(int amount) {
        money-=amount;
    }

    public boolean displayBuyingStatus(BuyableTile tile) {
        return false; //TODO
    }

    public boolean displayBuyingProposition(BuyableTile tile) {
        return false; //TODO
    }

    public int rollDiceRoutine() {
        diceCup.rollDice();
        return diceCup.getSum();
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
            System.out.println(i+") "+properties.get(i).tileName);
        }
    }

    private PropertyTile getPropertyChoice(){
        Scanner input = new Scanner( System.in );
        System.out.println("Which property do you want to build on ?");
        System.out.println("Type -1 to build on none.");
        ArrayList<PropertyTile> ownedProperties = getOwnedProperties();
        int p = input.nextInt();
        if(p<0 || p>ownedProperties.size()){
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
