/*
*=================================*
* Created  on 14-02-2020 10:53:15
* @author : VALLERICH Vincent
*=================================*
*/

package basic_interpret;

import basic_interpret.Interpret;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Interpret interpret = new Interpret();
        
        Scanner scan = new Scanner(System.in);
        String entry = scan.nextLine();
        
        while (!interpret.exit())
    }
}