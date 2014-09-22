/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

/**
 *
 * @author luciano
 */
public class Error {
    
    private int ln;
    private int cn;
    private String d;

    public Error(int lineNumber, int columnNumber, String desc) {
        ln=lineNumber;
        cn=columnNumber;
        d=desc;
    }
    
    public void show(){
        System.out.println("Line: "+ln+" Col:"+cn+" "+d);
    }
    
}
