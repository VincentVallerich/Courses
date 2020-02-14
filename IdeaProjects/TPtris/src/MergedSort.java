import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergedSort {
    public static <T extends Comparable<T>> Sequence sort(Sequence seq){
        if (seq.size()>1){
            Sequence s1 =seq.split(0,(seq.size())/2);//split ok
            Sequence s2 =seq.split((seq.size())/2,seq.size());//ok
            s1=MergedSort.sort(s1);
            s2=MergedSort.sort(s2);
            return MergedSort.fusion(s1,s2);//pas 0k
            }
        return seq;
    }

    private static  <T extends Comparable<T>> Sequence<T> fusion(Sequence<T> s1,Sequence<T> s2){//fusion pour tri par fusion
        LinkedList<T> myarray=new LinkedList<>();
        List<T> arr1=s1.list;//trié
        List<T> arr2=s2.list;//idem
        int i1=0,i2=0;
        while(i1<arr1.size() && i2<arr2.size()) {//tant qu'il y a des comparaisons
            if (arr1.get(i1).compareTo(arr2.get(i2)) < 0) {//arr1 + petit
                myarray.add(arr1.get(i1));
                i1++;
            } else {//arr2 + petit
                myarray.add(arr2.get(i2));
                i2++;
            }
        }
        //on finit de remplir:
        for(int i=i1;i<arr1.size();i++) {
            myarray.add(arr1.get(i));
        }
        for(int i=i2;i<arr2.size();i++) {
            myarray.add(arr2.get(i));
        }
        //System.out.println(arr1+" + "+arr2+" = "+myarray);
        return new Sequence<T>(myarray);
    }

}
