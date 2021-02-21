import java.util.Random;

public class PipedDice extends Dice {
    private static final int MIN = 1;
    private static final int MAX = 6;

    private static final int[] firstRolls = {3,5,2,4,4,1,3,1,5,1,6,4,2,1,6,3,4,2,5,3,4,2,3,3,6,5};
    private static final int predeterminedRollCount = 26;
    private static int rollCount = 0;

    private int value = 1;
    private final Random rdm = new Random();

    public PipedDice(){}

    public void roll() {
        if(rollCount<predeterminedRollCount){
            value = firstRolls[rollCount];
        } else {
            value = rdm.nextInt(MAX - MIN + 1) + MIN;
        }
        rollCount++;
    }

    public int getValue() {
        return value;
    }
}
