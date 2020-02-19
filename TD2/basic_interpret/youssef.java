package basic_interpret;

import java.util.Scanner;

import td_java.Counter;

public class youssef {
	Scanner sc = new Scanner(System.in);
	public boolean exit = false;
	private int a = sc.nextInt();
	private Counter c;
	
	public youssef() {
		c = new Counter("c1");
	}
	public String fetch() {
        printPrompt();
		return sc.next();
	}
	public void printPrompt() {
		System.out.print("->");
	}
	private void doMenu() {
		System.out.println("menu\n incr\n dcr\n plus\n minus\n value\n exit\n");
	}
	private void doIncr() {
		c.increment();
	}
	private void doDecre() {
		c.decrement();
	}
	private void doValue() {
		c.getValue();
	}
	private void doAdd() {
		System.out.println(c.getValue() + a);
	}
	private void doExit() {
		exit=true;
	}
	public boolean exit() {
		return exit;
	}
	public void execute(String m) {
        if (m=="menu") {
            doMenu();
        }
        if (m=="incr") {
            doIncr();
        }
        if (m=="decr") {
            doDecre();
        }
        if (m=="value") {
            doValue();
        }
        if (m=="plus") {
            doAdd();
        }
        if (m=="exit") {
            doExit();
        }else{
            doMenu();
        }
	}
}