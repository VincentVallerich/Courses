/*
*=================================*
* Created  on 14-02-2020 10:53:15
* @author : VALLERICH Vincent
*=================================*
*/

package basic_interpret;

import basic_interpret.Interpret;

public class App {
    public static void main(String[] args) {
        Interpret interpret = new Interpret();
        
        while (!interpret.exit()){
            interpret.execute(interpret.fetch());
        }
    }
}