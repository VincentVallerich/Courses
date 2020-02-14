import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Sequence <T extends Comparable<T>> {
    public List<T> list = new ArrayList();

    public static Sequence<Integer> genereSequence(int taille) {
        ArrayList<Integer> myarray = new ArrayList();
        Random rand = new Random();
        for (int i = 0; i < taille; i++)
            myarray.add(rand.nextInt(100));
        return new Sequence<Integer>(myarray);
    }

    public static Sequence<Integer> genereSequence(int taille, int borneinf, int bornesup) {
        ArrayList<Integer> myarray = new ArrayList();
        Random rand = new Random();
        for (int i = 0; i < taille; i++)
            myarray.add(rand.nextInt(bornesup - borneinf) + borneinf);
        return new Sequence<Integer>(myarray);
    }

    public Sequence(List<T> list) {
        this.list = list;
    }

    public void swap(int i, int j) {
        T buff = list.get(i);
        list.set(i, list.get(j));
        list.set(j, buff);
    }

    public void transform(){
        this.list=new LinkedList<T>(list);
    }

    public int size() {
        return list.size();
    }

    public T get(int index) {
        return list.get(index);
    }
    public void set(int index, T obj) {
        list.set(index,obj);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public Sequence<T> split(int first, int last) {
        return new Sequence<T>(new LinkedList<T>(list.subList(first, last)));
    }


}