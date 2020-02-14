import java.io.*;
import java.util.*;

public class HashTable {
    private ArrayList<ArrayList<MultiEns>> hashTable=new ArrayList<>();

    private void initTable(int prime){
        for(int i =0 ; i<prime;i++){
            this.hashTable.add(new ArrayList<>());
        }
    }

    private void append(String word){
        /*MultiEns ens=new MultiEns(word);
        for( MultiEns e : this.hashTable.get(ens.hash)){
            if(isSameWord(ens.sorted,e.sorted))
                return;
        }*/ //too long with that
        int key = MultiEns.hash(word);
        MultiEns ens=new MultiEns(key, word);
        for( MultiEns e : this.hashTable.get(ens.hash)){
            if(isSameWord(ens.sorted,e.sorted))
                return;
        }
        this.hashTable.get(key).add(ens);
    }

    public boolean isSameWord(String w1,String w2){
        //if(w1.size()!=w2.size())return false;
        //for(int i=0;i<w1.size();i++)if(!w1.get(i).equals(w2.get(i)))return false;//when we had List instead of Strings do you reember?
        //return true;
        return w1.equals(w2);//faster
    }


    public HashTable(String file,int prime) throws IOException {
        initTable(prime);
        File fic=new File(file);
        long time = 0;
        int over = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fic));
            String line;
            while((line = reader.readLine()) != null){
                //String line=scan.nextLine();
                if(line.length()>0)append(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }

    boolean contains(MultiEns ens){
        for(MultiEns e :hashTable.get(ens.hash)){
            if(isSameWord(e.sorted,ens.sorted)) {
                return true;
            }
        }
        return false;
    }

    String getWordOf(MultiEns ens){
        assert contains(ens);
        for(MultiEns e:hashTable.get(ens.hash)){
            if(isSameWord(e.sorted,ens.sorted))return e.word;
        };
        return  "";
    }


    List<String> getTuples(MultiEns sum){
        List<String> res=new LinkedList<>();
        for(List<MultiEns> l: hashTable){
            for(MultiEns e:l){//pour tous les mots
                if(e.isIn(sum)){
                    MultiEns cmpl=e.complementaireBy(sum);
                    if(contains(cmpl)){
                        res.add(e.word+"(<->)"+getWordOf(cmpl));
                    }
                }
            }
        }
        return res;

    }

}
