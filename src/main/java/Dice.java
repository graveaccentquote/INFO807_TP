import com.modeliosoft.modelio.javadesigner.annotations.objid;

import java.util.Random;

@objid ("b63428c3-52cb-4cfe-a70d-497d3a9631d7")
public class Dice {
    private static final int MIN = 1;
    private static final  int MAX = 6;
    private int value = 1;
    private Random rdm;

    public Dice(){
        rdm = new Random();
    }

    @objid ("55764f0c-c083-4518-b2c8-e50fddd1f9d9")
    public void Roll() {
        value = rdm.nextInt(MAX-MIN+1)+MIN;
    }

    @objid ("cad36ef5-b6ba-4da2-9650-94b3583b3551")
    public int GetValue() {
        return value;
    }
}
