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
    private boolean exitStatus = false;
    private Counter count;
    private Scanner scan = new Scanner(System.in);
    private final String DEFAULT_PROMPT = "=>";

    Interpret() { 
        count = new Counter("C1");
    }

    public void menu() {
        System.out.println("menu\nicr\ndcr\nplus\nminus\nvalue\nexit");
    }

    public void plus() {
        int i=0;
        final int ENTRY = returnInt();
        while (i!=ENTRY) {
            count.increment();
            i++;
        }
    }

    public void minus() {
        int i=0;
        final int ENTRY = returnInt();
        while (i!=ENTRY) {
            count.decrement();
            i++;
        }
    }

    public void increment() {
        count.increment();
    }

    public void decrement() {
        count.decrement();
    }

    public void value() {
        System.out.println(count.toString());
    }

    public boolean exit() {
        return exitStatus;
    }

    public void printPrompt() {
        System.out.print(DEFAULT_PROMPT);
    }

    public void execute(String exec) {
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
                plus();
                break;
            case "minus":
                minus();
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
        printPrompt();
        return scan.next();
    }

    private int returnInt() {
        System.out.print("Entrez votre nombre : ");
        return scan.nextInt();
    }
}