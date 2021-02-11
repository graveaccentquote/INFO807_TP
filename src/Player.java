import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a0cc559e-e021-471f-bd36-cab94d996b3b")
public class Player {
    @objid ("db69a380-e196-4731-831e-4f69aa20869f")
    private int money;

    @objid ("fb9cb127-0b6e-4c4d-90bc-bf0d03af8c4c")
    public List<BuyableTile> ownedTiles = new ArrayList<BuyableTile> ();

    @objid ("9722d000-3c5d-470f-b486-bb4b7e745ced")
    public MonopolyGame game;

    @objid ("f9510305-749f-4142-aa96-8964d30f4f65")
    public DiceCup diceCup;

    @objid ("6789d5b2-9fba-42f9-8afb-7b9722acaf66")
    public void PlayTurn() {
    }

    @objid ("ad04ff48-3070-4ba5-8a70-4f7657f95867")
    public boolean CanAfford(int amount) {
    }

    @objid ("d9606447-6427-4723-a44a-df22404c9265")
    public void Debit(int amount) {
    }

    @objid ("77f5a621-a706-4b91-b2f9-895ecc340d77")
    public boolean DisplayBuyingStatus(BuyableTile tile) {
    }

    @objid ("e06d9aaa-26c2-462f-ad22-1df787a623cd")
    public boolean DisplayBuyingProposition(BuyableTile tile) {
    }

    @objid ("02bc719e-a497-4f36-9205-7c95cbf94625")
    public int RollDiceRoutine() {
    }

    @objid ("266a60b3-2e0d-4b5c-9cda-9864c4d93d2b")
    private void ConstructionRoutine() {
    }

    @objid ("56e66eb5-b4a8-40e9-aea7-b2fb5cdad55f")
    private void CanPlayAgain() {
    }

    @objid ("e656ea75-9ebf-42d4-a48a-2b1a309123ba")
    private void DisplayOwnedProperties() {
    }

    @objid ("0217845d-3df5-42f4-8396-a2c5f8987361")
    public void TransferMoney(int amount, Player player) {
    }

    @objid ("4d43b9e0-d2e5-43d2-88f0-a40b8d0701c2")
    public void ReceiveMoney(int amount) {
    }

    @objid ("63e51d15-a0a5-4a08-98ee-c10cf43df78f")
    public int GetDiceSum() {
    }

}
