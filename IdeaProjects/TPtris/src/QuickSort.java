public class QuickSort {

    public static <T extends Comparable<T>> void sort(Sequence seq,int g, int d){//g&d sont des clès (index)!=obj
        if (g<d){//g<d
            int pivot=g+((d-g)/2);
            pivot=QuickSort.flagPartition(seq,g,d,pivot);
            QuickSort.sort(seq,g,pivot-1);
            QuickSort.sort(seq,pivot+1,d);

        }
    }

    private static <T extends Comparable<T>> int flagPartition(Sequence<T> seq,int g,int d, int pivot){
        T pivotValue=seq.get(pivot);
        int i=g, equalsPivot=i, processSize=d-g;
        seq.swap(i,pivot);
        i++;processSize--;
        while(processSize>=0) {
            T iValue = seq.get(i);//valeur que l'on compare et bouge
            if(iValue.compareTo(pivotValue)>0){//+ gd vas à droite
                seq.swap(i,i+processSize);
            }
            else if(iValue.compareTo(pivotValue)<0)// + petit, vas à gauche
            {
                seq.swap(i,equalsPivot);
                i++;
                equalsPivot++;
            }
            else {
                i++;// == on passe au suivant
            }
            processSize--;
        }
        return i-1;//position du pivot (position qu'on regarde -1)
    }

    public static <T extends Comparable<T>> void sort(Sequence seq){
        QuickSort.sort(seq,0,seq.size()-1);
    }

    //todo: quick partition
}
