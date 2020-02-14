import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static Set getSet(int n,int bound){
        Random rand = new Random();
        Set set=new Set();
        for (int i = 0; i < n; i++)
            set.add(new Item(rand.nextInt(bound)+1,rand.nextInt(bound)));
        return set;
    }

    public static void main(String[] args) {
        Set set=Main.getSet(10,5);
        set.sort();
        /*for(Item i:set.content){
            System.out.println("(poid: "+i.getPoid()+", val: "+i.getVal()+", ratio: " + i.getRatio() + ")");
        }
        System.out.println(set);
        */long start = System.nanoTime();
        ArrayList<Item>arr=new ArrayList<>();
        arr.add(new Item(5,10));
        arr.add(new Item(3,5));
        arr.add(new Item(4,7));
        set=new Set(arr);
        System.out.println(ExhaustiveSolve.solve(new SacADos(7),set));
        System.out.println(String.format("Took %d ms", (System.nanoTime() - start) / 1000 / 1000));
        //DynamicSolve solve=new DynamicSolve(new SacADos(5),set);
        //System.out.println(solve.toString());

        System.out.println(ESolve.solve(new SacADos(7),set,0));
        System.out.println(String.format("Took %d ms", (System.nanoTime() - start) / 1000 / 1000));
        start = System.nanoTime();
        Solve soluce=new Solve(new SacADos(7),set);
        System.out.println(String.format("Took %d ms", (System.nanoTime() - start) / 1000 / 1000));
    }
}
