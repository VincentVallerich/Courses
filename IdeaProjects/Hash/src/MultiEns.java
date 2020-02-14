import java.util.Arrays;

public class MultiEns {
    final static int PRIME=756839;//193939;//8181; //108881;////701;//todo test with biger prime ~ 400 000 000 (8181)+rapid+other words more efficient?
    final static int BASE=256;


    String sorted;
    String word;
    int hash;

    public MultiEns(String sorted) {
        this.sorted = sorted;
        this.word = "";
        this.hash = MultiEns.hash(sorted);
    }

    public MultiEns(int key, String word) {
        this.sorted = MultiEns.sortWord(word);
        this.word = word;
        this.hash = key;
    }

    static int hash(String word, int base, int premier){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        long hash = 0;
        long mul = 1;
        for (char letter: chars) {
            hash += (letter * mul) % premier;
            mul *= base;
        }
        return Math.abs(Math.round(hash % premier));
        //List<String> sortedWord= sortWord(word);
        //return hashOfSorted(sortedWord,base,premier);
    }

    /*static int hashOfSorted(String sortedWord, int base, int premier){
        long hash=0;
        long mul=1;
        for(String letter:sortedWord.toCharArray()){
            hash+=letter.codePointAt(0)*mul;
            mul*=base;
        }
        return Math.abs((int) hash%premier);
    }*/

    static int hash(String word) {
        return hash(word,BASE,PRIME);
    }

    static String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Override
    public String toString() {
        return String.join(",",sorted)+"|"+word;
    }

    boolean isIn(MultiEns ens){
        char[] ensSet= cloneSorted(ens).toCharArray();
        for(char car:sorted.toCharArray()){
            if(indexOf(ensSet, car) < 0)return false;
            else ensSet = removeCharAt(ensSet, indexOf(ensSet, car));
        }
        return true;
    }

    private static int indexOf(char[] source, char searched) {
        for (int i = 0; i < source.length; i++)
            if (source[i] == searched)
                return i;

        return -1;
    }

    private static char[] removeCharAt(char[] source, int index) {
        char[] target = new char[source.length - 1];
        System.arraycopy(source, 0, target, 0, index);
        System.arraycopy(source, index + 1, target, index, source.length - index - 1);
        return target;
    }


    MultiEns complementaireBy(MultiEns sum){
        assert (isIn(sum));
        char[] ensSet = cloneSorted(sum).toCharArray();

        for(char car: sorted.toCharArray()){
            //ensSet.remove(ensSet.lastIndexOf(car));
            int index = indexOf(ensSet, car);
            if(index < 0) continue;
            ensSet = removeCharAt(ensSet, index);
        }
        return new MultiEns(new String(ensSet));
    }

    /*
    MultiEns complementaireBy(MultiEns sum){
        assert (isIn(sum));
        List<String> ensSet= new LinkedList<>();
        ensSet.addAll(sum.sorted);
        for(String car:sorted){
            ensSet.remove(ensSet.lastIndexOf(car));
        }
        return new MultiEns(ensSet);
    }

     */
    String cloneSorted(MultiEns ens){
        return new String(ens.sorted);
    }
}
