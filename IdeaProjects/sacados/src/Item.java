import java.util.Objects;

public class Item {
    private int val;
    private int poid;

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "(" +
                poid +
                ", " + val +
                ')';
    }

    public int getPoid() {
        return poid;
    }

    public Item(int poid, int val) {
        this.poid = poid;
        this.val = val;
    }

    public float getRatio(){
        return (float)val/(float)poid;
    }

    public Item clone(){
        return new Item(poid,val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return val == item.getVal() &&
                poid == item.getPoid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, poid);
    }
}