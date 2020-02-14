import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static void sort(Sequence<Integer> seq){
        int base=256;

        int tour=0;//1er tour
        boolean isNotDone=true;

        while(isNotDone){//O(logbase(max(n)))*O(n)
            isNotDone=false;

            //System.out.println(seq);

            int[] nb=new int[base];//pr compter les elments
            Arrays.fill(nb,0);//rempli nb de 0 (O(base))

            for (int i=0 ;i<seq.size();i++){//O(n), mais doit les parcourir tous ?????

                int categorie=getCategorie(seq,i,base,tour);//on récupere le critère de comparaison O(1)
                //System.out.println("*==*"+getCategorie(seq,i,base,tour));
                nb[categorie]+=1;
                //System.out.println("on a @i "+seq.get(i)+" donc on fait ++ a "+getCategorie(seq,i,base,tour));
                isNotDone=isNotDone||isnotDone(seq,i,base,tour);//necessaire de faire un tour de plus? O(1)
            }

            int[] pos=new int[base];//tableau des positions
            pos[0]=0;
            for (int i=1 ;i<base;i++){//on set pos celon algo du cours O(base)
                pos[i]=pos[i-1]+nb[i-1];//on commence à i-1 puis on ajoutele nb pr nous
            }

            //System.out.println("pos="+ Arrays.toString(pos)+" &nb="+Arrays.toString(nb));
            reordone(seq,pos,base,tour);//met à jour en fonction de pos (O(n))
            tour++;
        }
    }


    private static int getCategorie(Sequence <Integer> seq,int index, int base,int tour){//extrait l'element que l'on va comparer (entre 0 et base au tour=tour)
        return ((int)(seq.get(index)/Math.pow(base,tour))%base);
    }

    private static boolean isnotDone(Sequence <Integer> seq,int index, int base,int tour){//return true si necessaire de fair un tour de +
        return base<(int)(seq.get(index)/Math.pow(base,tour));
    }

    private  static ArrayList<Integer> getCopy(Sequence<Integer> seq){//O(n)
        ArrayList<Integer> modifiedcopy=new ArrayList<>();

        for (int i=0 ;i<seq.size();i++){//copy liste ds mod
            modifiedcopy.add(seq.get(i));
        }
        return modifiedcopy;
    }

    private static void reordone(Sequence<Integer> seq,int[] pos,int base,int tour){//O(n)
        Sequence<Integer> copy=new Sequence<>(getCopy(seq));
        for(int i=0; i<seq.size();i++){
            int cat=getCategorie(copy,i,base,tour);
         //   System.out.println(seq.toString()+ " on vas mette: "+seq.get(i)+" @ "+pos[cat]);
            seq.set(pos[cat],copy.get(i));
            pos[cat]++;
        }

    }


}
