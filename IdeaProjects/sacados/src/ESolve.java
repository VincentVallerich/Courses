public class ESolve {

    public static int solve(SacADos sac, Set items,int n) {//suppose que set est trié
        if(n==items.content.size())return sac.getSumVal();
        Item it=items.content.get(n);
        int val=0;
        //on prend
        if(sac.add(it)){
            val= solve(sac,items,n+1);
            sac.remove(it);
        }
        //on prend pas
        return Math.max(val,solve(sac,items,n+1));
    }

}
