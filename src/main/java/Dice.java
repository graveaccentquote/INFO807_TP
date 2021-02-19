import java.util.Random;

public class Dice {
    private static final int MIN = 1;
    private static final  int MAX = 6;
    private int value = 1;
    private Random rdm;

    public Dice(){
        rdm = new Random();
    }

    public void roll() {
        value = rdm.nextInt(MAX-MIN+1)+MIN;
    }

    public int getValue() {
        return value;
    }
}
