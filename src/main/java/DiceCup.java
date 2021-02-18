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

    public void RollDice() {
        for (Dice d : dice) {
            d.Roll();
        }
    }

    public boolean CheckDouble() {
        if(dice.size()<2) return false;
        return dice.get(0).GetValue() == dice.get(1).GetValue();
    }

    public int GetSum() {
        int sum = 0;
        for(Dice d : dice){
            sum += d.GetValue();
        }
        return sum;
    }

}
