public class ExhaustiveSolve {

    /*public static int solve(SacADos sac,Set items){//suppose que set est trié
        //System.out.println(items);
        //System.out.println("s:"+items.size());
        int val=sac.getSumVal();
        for (Item it :items.content){
            if (!sac.add(it)) {
                continue;
            }
            Set set=items.clone();
            set.remove(it);
            if(set.size()>0&&sac.getSumVal()+(set.content.get(0).getRatio()*(sac.capacity-sac.getSumVal()))<=val){
                continue;
            }
            //System.out.println(sac.getSumVal());
            //System.out.println(set);
            int solved=solve(sac,set);
            //System.out.println("choose:"+ it.getPoid()+" with val:"+it.getVal());
            if(solved>val) {
                //System.out.println("choose:"+ solved+" over:"+val);
                val = sac.getSumVal();
                //System.out.println(sac);
            }
            //System.out.println(sac.getSumVal());
            sac.remove(it);
            //System.out.println("remove : "+it);
        }
        return val;
    }*/
    public static int solve(SacADos sac, Set items) {//suppose que set est trié
        int val = sac.getSumVal();//valeurs oa

        for (Item it : items.content) {
            if (!sac.add(it)) {//on a pas pu ajouter cet element, trop gros
                continue;
            }

            Set set = items.clone();//can't modif on what you're iterate
            set.remove(it);//on a pris it on pourras pas le reprendre

            if(set.size()>0&&(sac.getSumVal()+(set.content.get(0).getRatio()*(sac.capacity-sac.getSumPoid())))<val){
                sac.remove(it);
                continue;
            }

            int solved = solve(sac, set);
            if (solved >= val) {
                val = solved;
                //System.out.println(sac);
            }
            sac.remove(it);
        }
        return val;
    }

}
