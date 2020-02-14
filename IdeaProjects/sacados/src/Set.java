import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Set {
    List<Item> content;

    public Set(List<Item> content) {
        this.content = content;
    }
    public Set() {
        this(new ArrayList<Item>());
    }

    public void add(Item i){
        content.add(i);
    }
    public void remove(Item i){
        content.remove(i);
    }

    public void sort(){
        content.sort(((i1,i2) -> {
            if(i1.getRatio()==i2.getRatio())return Integer.compare(i1.getPoid(),i2.getPoid());
            return Float.compare(i2.getRatio(),i1.getRatio());
        }));
    }

    public Set clone(){
        ArrayList<Item> clone=new ArrayList<>();
        for(Item it:content){
            clone.add(it.clone());
        }
        return new Set(clone);
    }

    @Override
    public String toString() {
        return content.toString();
    }

    public int size(){
        return content.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        return Objects.equals(content, set.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    public int getSumPoid(){
        return  content.stream().mapToInt(Item::getPoid).sum();
    }

    public int getSumVal(){
        return  content.stream().mapToInt(Item::getVal).sum();
    }


}
