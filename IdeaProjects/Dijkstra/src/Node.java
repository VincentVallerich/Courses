import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Node {

    LinkedList<Ark> voisins=new LinkedList<Ark>();

    public LinkedList<Ark> getVoisins() {
        return voisins;
    }

    public boolean hasVoisin(Node to){
        for(Ark a:voisins) {
            if(a.getTo().equals(to))
                return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return node.voisins.containsAll(((Node) o).voisins)&&voisins.containsAll(node.voisins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voisins);
    }
}
