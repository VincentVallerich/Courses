/*
*=================================*
* Created  on 14-02-2020 10:58:25
* @author : VALLERICH Vincent
*=================================*
*/

package basic_interpret;

import td_java.Counter;

public class Interpret {
    Counter count = new Counter();

    Interpret() { }

    public void menu() {
        System.out.println("menu");
        System.out.println("icr");
        System.out.println("dcr");
        System.out.println("plus");
        System.out.println("minus");
        System.out.println("value");
        System.out.println("exit");
    }

    public void plus(value) {
        int i=0;
        while (i!=value)
            count.increment();
    }

    public void minus(value) {
        int i=0;
        while (i!=value)
            count.decrement();
    }

    public void increment() {
        count.increment();
    }

    public void decrement() {
        count.decrement();
    }

    public String value() {
        return count.toString();
    }

    public boolean exit() {
        return false;
    }
}