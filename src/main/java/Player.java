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

    public void PlayTurn() {
        do{
            int distance = RollDiceRoutine();
            game.MovePlayer(distance);
        } while(CanPlayAgain());
    }

    public boolean CanAfford(int amount) {
        return money>=amount;
    }

    public void Debit(int amount) {
        money-=amount;
    }

    public boolean DisplayBuyingStatus(BuyableTile tile) {
        return false; //TODO
    }

    public boolean DisplayBuyingProposition(BuyableTile tile) {
        return false; //TODO
    }

    public int RollDiceRoutine() {
        diceCup.RollDice();
        return diceCup.GetSum();
    }

    private void ConstructionRoutine() {
        DisplayOwnedProperties();
        PropertyTile t = GetPropertyChoice();
        if(t!= null){
            t.Build();
        }
    }

    private boolean CanPlayAgain() {
        return diceCup.CheckDouble();
    }

    private void DisplayOwnedProperties() {
        System.out.println("Current player's properties :");
        ArrayList<PropertyTile> properties = GetOwnedProperties();
        for(int i=0;i<properties.size();i++){
            System.out.println(i+") "+properties.get(i).tileName);
        }
    }

    private PropertyTile GetPropertyChoice(){
        Scanner input = new Scanner( System.in );
        System.out.println("Which property do you want to build on ?");
        System.out.println("Type -1 to build on none.");
        ArrayList<PropertyTile> ownedProperties = GetOwnedProperties();
        int p = input.nextInt();
        if(p<0 || p>ownedProperties.size()){
            return null;
        } else {
            return ownedProperties.get(p);
        }
    }

    private ArrayList<PropertyTile> GetOwnedProperties(){
        ArrayList<PropertyTile> res = new ArrayList<PropertyTile>();
        for(BuyableTile tile : ownedTiles){
            if(tile instanceof PropertyTile){
                res.add((PropertyTile)tile);
            }
        }
        return res;
    }

    public void TransferMoney(int amount, Player player) {
        this.Debit(amount);
        player.ReceiveMoney(amount);
    }

    public void ReceiveMoney(int amount) {
        money+= amount;
    }

    public int GetMoney() {
        return money;
    }

    public int GetDiceSum() {
        return diceCup.GetSum();
    }

}
