

public class DynamicSolve {
    SacADos sac;
    Set set;
    Integer[][] a;

    public DynamicSolve(SacADos sac, Set set) {
        this.sac = sac;
        this.set = set;
        a=new Integer[set.size()][sac.capacity+1];
        for(int i=0;i<sac.capacity;i++)
            a[0][i]=0;
        System.out.println(solve(set.size()-1,sac.capacity));
    }

    @Override
    public String toString() {
        String s="";
        for(Integer[] i1:a) {
            for (Integer i2 : i1) {
                s += " " + i2 + " ";
            }
            s += ",\n";
        }
        return s;
    }

    public Integer solve(int i, int poid) {
        if (i < 0) return 0;
        if (a[i][poid] != null) return a[i][poid];
        int pp = set.content.get(i-1).getPoid();
        int v = set.content.get(i-1).getVal();
        if (pp <= poid){
            int r1=this.solve(i - 1, poid);
            int r2=this.solve(i - 1, poid - pp) + v;
            a[i][poid] = Math.max(r1, r2);
        }
        else a[i][poid]=a[i-1][poid];
        return solve(i-1,poid);

    }


}
