import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3017c789-48b2-4ff9-9e45-f4efb2e981ae")
public class PropertyLot extends BuyableLot {
    @objid ("5de76769-4f8d-4c2f-acf7-3ee5a0c841c4")
    public int maxBuildingCount;

    @objid ("87ee884e-717c-4917-ae2a-80aaa8505e64")
    public int minBuildingCount;

    @objid ("b2c882c3-432c-4737-a628-046f92dc41e4")
    public List<PropertyTile> children = new ArrayList<PropertyTile> ();

    @objid ("d166562d-193f-4408-a27d-bd8cefb5dbe3")
    public void OnBuildEvent() {
    }

    @objid ("ed2123c5-206f-43cf-a4fa-22a54034505d")
    public boolean IsValidBuildingCount(int buildingCount) {
    }

}
