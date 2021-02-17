import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c7d72462-e678-413d-a32e-0f34e97af2f9")
public abstract class Tile {

    public String tileName;

    ///Methods
    @objid ("3b476daf-4be0-4346-b183-7bd2155efe97")
    public abstract void ApplyOnStop(Player player);

    @objid ("8315b236-e5ca-48f0-ac9a-9bf435876fc8")
    public abstract void ApplyOnPassBy(Player player);

    public String getTileName()
    {
        return this.tileName;
    }

}
