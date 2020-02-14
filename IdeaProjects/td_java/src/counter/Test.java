package counter;

public class Test {
    public static void main(String[] args){
        Counter c1 = new Counter("c1");
        Counter c2 = new Counter("c2",1);

        System.out.println(c1);
        System.out.println(c2);

        c1.increment();
        System.out.println(c1);

        c2.setValue(0);
        System.out.println(c2);

        c1.decrement();
        System.out.println(c1);

        c1.decrement();
        System.out.println(c1);
    }
}
