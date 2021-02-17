import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f1da2aa9-5be3-4f20-800d-33f9d4529e07")
public class DiceCup {
    private static final int DICE_COUNT = 2;

    @objid ("3cf68c26-2bdd-4a06-9e53-ac86164800bb")
    private List<Dice> dice = new ArrayList<Dice> ();

    public DiceCup(){
        for(int i = 0; i<DICE_COUNT; ++i){
            dice.add(new Dice());
        }
    }

    @objid ("1aab0578-54f7-4727-aef7-1cd8c936226c")
    public void RollDice() {
        for (Dice d : dice) {
            d.Roll();
        }
    }

    @objid ("73914423-d8e9-4c56-9da2-c0bca49b390a")
    public boolean CheckDouble() {
        if(dice.size()<2) return false;
        return dice.get(0).GetValue() == dice.get(1).GetValue();
    }

    @objid ("a2840eac-f193-4d32-a711-4af2ecc5ab8d")
    public int GetSum() {
        int sum = 0;
        for(Dice d : dice){
            sum += d.GetValue();
        }
        return sum;
    }

}
