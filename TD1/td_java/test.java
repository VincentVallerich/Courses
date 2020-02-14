/*
*=================================*
* Created  on 06-02-2020 20:24:27
* @author : VALLERICH Vincent
*=================================*
*/

package td_java;

import td_java.Counter;

public class test {
    public static void main(String[] args) {
        Counter c1 = new Counter("C1", 4);
        Counter c2 = new Counter("C2", 10);

        c1.increment();
        System.out.println(c1.getName());
        System.out.println(c2.toString());
    }
}