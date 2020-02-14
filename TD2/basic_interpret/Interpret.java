/*
*=================================*
* Created  on 14-02-2020 10:58:25
* @author : VALLERICH Vincent
*=================================*
*/

package basic_interpret;

import td_java.Counter;
import java.util.Scanner;

public class Interpret {
    boolean exitStatus = false;
    Counter count = new Counter("Counter", 0);
    Scanner scan = new Scanner(System.in);
    String entry;
    int value;

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

    public void plus(int value) {
        int i=0;
        while (i!=value)
            count.increment();
    }

    public void minus(int value) {
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
        return exitStatus;
    }

    public void execute(String exec) {
        System.out.println("=>");
        switch(exec) {
            case "icr": 
                increment();
                break;
            case "dcr": 
                decrement();
                break;
            case "value": 
                value();
                break;
            case "plus":
                System.out.println("Entrez votre nombre : ");
                value = scan.nextInt();
                plus(value);
                break;
            case "minus":
                System.out.println("Entrez votre nombre : ");
                value = scan.nextInt();
                minus(value);
                break;
            case "exit":
                exitStatus = true;
                break;
            default:
                menu();
                break;
        }
    }

    public String fetch() {
        return scan.nextLine();
    }
}