import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static <T extends Comparable> boolean  checkEquals(List<T> l1, List<T> l2){
        for(int i=0;i<l1.size();i++){
            if(l1.get(i).compareTo(l2.get(i))!=0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Sequence<Integer> seq = Sequence.genereSequence(1_000,0,1000);
        //System.out.println(seq);//seq fait ce qui est attendu
        List<Integer> cp= new LinkedList<>(seq.list),cp2=new ArrayList<>(seq.list),cp3=new ArrayList<>(seq.list);//liked list pr merged dans cp
        List<Integer> cp4= new ArrayList<>(seq.list);
        Sequence<Integer> seq2=new Sequence<>(cp);//on copy pour trier la même liste
        Sequence<Integer> seq3=new Sequence<>(cp2);//on copy pour trier la même liste
        Sequence<Integer> seq4=new Sequence<>(cp3);//on copy pour trier la même liste
        Sequence<Integer> seq5=new Sequence<>(cp4);//on copy pour trier la même liste


        System.out.println("Warming up merge sort");
        for (int i = 0; i < 100; i++) {
            Sequence<Integer> temp = new Sequence<>(cp);
            MergedSort.sort(temp);
        }

        System.out.println("Warming up quick sort");
        for (int i = 0; i < 100; i++) {
            Sequence<Integer> temp = new Sequence<>(cp);
            QuickSort.sort(temp);
        }

        System.out.println("Warming up heap sort");
        for (int i = 0; i < 100; i++) {
            Sequence<Integer> temp = new Sequence<>(cp);
            HeapSort.sort(temp);
        }

        int iter = 15;

        long time=0;
        for (int i = 0; i < iter; i++) {
            Sequence<Integer> temp = new Sequence<>(cp);
            long start = System.nanoTime();
            QuickSort.sort(temp);
            time += System.nanoTime() - start;
        }
        double took = (time / ((double) iter)) / 1_000_000;
        System.out.println("Quick sort in  "+(took)+" ms");

        time=0;
        for (int i = 0; i < iter; i++) {
            Sequence<Integer> temp = new Sequence<>(cp);
            long start = System.nanoTime();
            HeapSort.sort(temp);
            time += System.nanoTime() - start;
        }
        took = (time / ((double) iter)) / 1_000_000;
        System.out.println("Heap sort in  "+(took)+" ms");

        time=0;
        for (int i = 0; i < iter; i++) {
            Sequence<Integer> temp = new Sequence<>(cp);
            long start = System.nanoTime();
            MergedSort.sort(temp);
            time += System.nanoTime() - start;
        }
        took = (time / ((double) iter)) / 1_000_000;
        System.out.println("Merge sort in  "+(took)+" ms");

        time=0;
        for (int i = 0; i < iter; i++) {
            Sequence<Integer> temp = new Sequence<>(cp);
            long start = System.nanoTime();
            RadixSort.sort(temp);
            time += System.nanoTime() - start;
        }
        took = (time / ((double) iter)) / 1_000_000;
        System.out.println("Radix sort in  "+(took)+" ms");

        /*time=System.nanoTime();
        HeapSort.sort(seq4);
        System.out.println("heap sort in   "+(System.nanoTime()-time)/1000+" E-6 s");

        time=System.nanoTime();
        seq2=MergedSort.sort(seq2);
        System.out.println("Merged sort in "+(System.nanoTime()-time)/1000+" E-6 s");*/

     //   time=System.nanoTime();
        //System.out.println(seq)
        //Bubblesort.sort(seq);
        //System.out.println(seq);
   //     System.out.println("bubble sort in "+(System.nanoTime()-time)/1000+" E-6 s");

        if(checkEquals(seq3.list,seq2.list)&&checkEquals(seq4.list,seq2.list))//&&checkEquals(seq.list,seq2.list))//)//check all sorts are working
            System.out.println("all sequence sorted are the same");
    }


}
