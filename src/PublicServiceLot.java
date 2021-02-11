import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fd528a68-23ab-49d0-b9d8-4f4aa8f50f7e")
public class PublicServiceLot extends BuyableLot {
    @objid ("09c34a75-0365-4164-b89e-82a421a4972e")
    public List<PublicServiceTile> children = new ArrayList<PublicServiceTile> ();

}
