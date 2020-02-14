
public class HeapSort {

    private static class HeadMax<T extends Comparable<T>>{//structure de donnée utilisées ds algo et methodes associées
        protected int taille;

        public int getTaille() {
            return taille;
        }

        public void setTaille(int taille) {
            this.taille = taille;
        }

        public HeadMax(Sequence<T> seq){
            setTaille(seq.size());
            turnIntoStackMax(seq);
        }

        private int getParentID(int i){
            return i/2;
        }
        private int getLeftChild(int i){ return (i*2); }
        private int getRightChild(int i){
            return getLeftChild(i)+1;
        }
        private <T extends Comparable<T>> void checkStackMaxFor(Sequence<T> stack, int i){
     /*
                fct preserve qualitée de tas-max si  left child et right child sont tas-max mais que stack.get(i)
                pas certain, si besoin fait descendre dans tas => O(log(n))  Pck on descend log2(n) fois max si n=seq.size
         */
            int l=getLeftChild(i),r=getRightChild(i),max;
            if(l<taille&&stack.get(i).compareTo(stack.get(l))<0)
                max=l;
            else
                max=i;
            if(r<taille&&stack.get(max).compareTo(stack.get(r))<0)
                max=r;
            if(max!=i) {
                stack.swap(i,max);
                checkStackMaxFor(stack,max);
            }
        }

        private <T extends Comparable<T>>  void turnIntoStackMax(Sequence<T> stack){
            for(int i=(stack.size()-1)/2;i>=0;i--)//~n
                checkStackMaxFor(stack,i);//~log(n)
        }
    }


    public static <T extends Comparable<T>> void sort(Sequence seq){
        HeadMax stack=new HeadMax<T>(seq);//seq devient stack-Max
        for(int i=seq.size()-1;i>0;i--){
            seq.swap(0,i);
            stack.setTaille(stack.getTaille()-1);
            stack.checkStackMaxFor(seq,0);
        }

    }

}
