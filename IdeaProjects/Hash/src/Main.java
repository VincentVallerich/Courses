import java.io.IOException;

public class Main {
    public static void main(String[] args ) throws IOException {
        long time = System.currentTimeMillis();
        HashTable ht=new HashTable("res/dico.txt", MultiEns.PRIME);
        System.out.println(System.currentTimeMillis()-time);
        time = System.currentTimeMillis();
        String w="renaudrochas";
        MultiEns word=new MultiEns(MultiEns.hash(w),w);
        System.out.println(ht.getTuples(word));
        System.out.println(System.currentTimeMillis()-time);
    }
}
