import java.util.ArrayList;
import java.util.List;

public class DiceCup {
    private static final int DICE_COUNT = 2;

    private List<Dice> dice = new ArrayList<Dice> ();

    public DiceCup(){
        for(int i = 0; i<DICE_COUNT; ++i){
            dice.add(new Dice());
        }
    }

    public void rollDice() {
        for (Dice d : dice) {
            d.roll();
        }
    }

    public boolean checkDouble() {
        if(dice.size()<2) return false;
        return dice.get(0).getValue() == dice.get(1).getValue();
    }

    public int getSum() {
        int sum = 0;
        for(Dice d : dice){
            sum += d.getValue();
        }
        return sum;
    }

}
