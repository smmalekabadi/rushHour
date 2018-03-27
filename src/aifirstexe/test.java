/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aifirstexe;

/**
 *
 * @author Taknovin
 */
public class test implements Cloneable{
    int a = 10;
    public test(){
        
    
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
}
