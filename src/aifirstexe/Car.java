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
public class Car implements Cloneable{
    public int carNo;
    public int carSize;
    public int startX,  startY;
    public String state;
    public Car (int carno , int startX , int startY , String state,int carsize ){
        this.carNo=carno;
        this.carSize=  carsize;
        this.startX= startX;
        this.startY = startY;
        this.state = state;
    }
    public boolean canMove (Map map,String diraction,int count){
        for (int i = 1 ;i <= count ; i++){
        if (diraction.equals("l")){
                if (startY < i || !map.isCellEmpty[startX][startY-i] )
                    return false;
                    
        }
        else if (diraction.equals("r")){
            if(carSize==2){
                if (startY >= 5-i || !map.isCellEmpty[startX][startY+1+i]){
                    return false;
                }
            }
            else {
                    if (startY >= 4-i || !map.isCellEmpty[startX][startY+2+i]){
                    return false;
                    }
            }
        }
         else if (diraction.equals("u")){
                if (startX < i || !map.isCellEmpty[startX-i][startY]){
                    return false;}
         }
         else if (diraction.equals("d")){
             if (carSize==2){
                if (startX >= 5-i  ||  !map.isCellEmpty[startX+1+i][startY]){
                    return false;}
             }
             else {
                 if (startX >= 4-i || !map.isCellEmpty[startX+2+i][startY]){
                    return false;
                     
                 }
             }
         }
        }
        return true;
    }
    public boolean doMove(Map map,String diraction, int distance){

                if (!canMove(map, diraction,distance)){
                    System.out.println("hiiii "+carNo);
                    return false ; 
                   
                }
            for (int i = 0 ; i < distance ; i++){
                if (diraction.equals("l")){
                     map.isCellEmpty[startX][startY-1] = false;
                     map.map[startX][startY-1]= carNo ;
                    if (carSize == 2 ){
                       
                        map.isCellEmpty[startX][startY+1] = true;
                        map.map[startX][startY+1]= 0 ;
                    }
                    else{
                        map.isCellEmpty[startX][startY+2] = true;
                        map.map[startX][startY+2]= 0 ;}
                    startY--;
                }
                else if (diraction.equals("r")){
                    map.isCellEmpty[startX][startY] = true;
                    map.map[startX][startY]= 0 ;
                    if (carSize == 2 ){   
                        map.isCellEmpty[startX][startY+2] = false;
                        map.map[startX][startY+2]= carNo;
                    }
                    else{ 
                        map.isCellEmpty[startX][startY+3] = false;
                        map.map[startX][startY+3]= carNo ;}
                    startY++;
                }
                else if (diraction.equals("u")){
                    map.isCellEmpty[startX-1][startY]= false;
                    map.map[startX-1][startY]= carNo ;
                    if (carSize == 2 ){
                        map.isCellEmpty[startX+1][startY]= true;
                        map.map[startX+1][startY]= 0 ;
                    }
                    else {
                        map.isCellEmpty[startX+2][startY]= true;
                        map.map[startX+2][startY]= 0 ;
                    }
                    
                    startX--;
                }
                else {
                        map.isCellEmpty[startX][startY]= true;
                        map.map[startX][startY]= 0 ;
                if (carSize == 2 ){
                        map.isCellEmpty[startX+2][startY]= false;
                        map.map[startX+2][startY]= carNo ;
                }
                    else {
                        map.isCellEmpty[startX+3][startY]= false;
                        map.map[startX+3][startY]= carNo ;
                    }
                    startX++;
                }
                    
               
            }
            return true;
    
    }
    
    public Object clone() throws CloneNotSupportedException{
    return super.clone();
    }
   
    
}
