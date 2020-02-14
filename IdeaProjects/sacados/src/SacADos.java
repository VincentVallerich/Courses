import java.util.ArrayList;

public class SacADos {
    int poid=0;
    int val=0;
    ArrayList<Item> content=new ArrayList<>();

    public SacADos(int poid, int val, ArrayList<Item> content, int capacity) {
        this.poid = poid;
        this.val = val;
        this.content = content;
        this.capacity = capacity;
    }

    int capacity;

    public SacADos(int capacity) {
        this.capacity = capacity;
    }

    public boolean add(Item i){
        //System.out.println("poid after="+(poid+i.getPoid())+" capacity= "+capacity);
        if (poid + i.getPoid() > capacity) {
            return false;
        }
        content.add(i);
        poid+=i.getPoid();
        val+=i.getVal();
        //System.out.println("add");
        return true;
        //System.out.println("n'a pas ajouté ("+i.getPoid()+","+i.getVal()+") to sac"+content);
    }

    public void remove(Item i){
        content.remove(i);
        val -= i.getVal();
        poid -= i.getPoid();
    }

    public int getSumPoid(){
        return  poid;
    }

    public int getSumVal(){
        return  val;
    }

    @Override
    public String toString() {
        return "SacADos{" +
                "poid=" + poid +
                ", val="+val +
                ", capacity=" + capacity +
                ", conten=" + content+
                '}';
    }
    public SacADos clone(){
        return new SacADos(poid,val,(ArrayList<Item>) content.clone(),capacity);
    }

}
