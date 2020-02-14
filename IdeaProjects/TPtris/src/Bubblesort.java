
public class Bubblesort {
    public static <T extends Comparable<T>> void sort(Sequence seq){//algo cours
        for (int i = seq.size(); 0<i; i--) {
            for(int j=0; j < i-1; j++) {
                if (seq.get(j).compareTo(seq.get(j+1))>0){
                    seq.swap(j,j+1);
                }
            }
        }
    }
}
