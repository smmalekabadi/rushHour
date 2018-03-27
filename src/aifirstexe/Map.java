/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aifirstexe;

import java.util.ArrayList;
import aifirstexe.Car;

/**
 *
 * @author Taknovin
 */
public class Map implements Cloneable{
    public ArrayList<Car>  carlist = new ArrayList<Car>();
    public static final int row = 6  , column = 6 ;
    public static final int exitX = 5, exitY = 2;
    public int map[][];
    public boolean isCellEmpty[][];
    private ArrayList<Car> ArrayList;
    public Map(){
        map = new int[row][column];
        isCellEmpty= new boolean[row][column];
        for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                       isCellEmpty[i][j]= true;
                       map[i][j] = 0 ;
                }
        }
    }
    
    public boolean addCarToMap(Car car){
       
        if (!canCarFitInMap(car)){
       
            
            return false;
           
        }
        updateMap(car);
        carlist.add(car);
        return true;
 
    }
   public boolean canCarFitInMap(Car car){
   if(!isCellEmpty[car.startX][car.startY]){
         return false;
        }
   if (car.state.equals("h")){
       if(!isCellEmpty[car.startX][car.startY+1])
           return false;
       if(car.carSize==3) 
           if(!isCellEmpty[car.startX][car.startY+2])
                return false;
   }
   else{
        if(!isCellEmpty[car.startX+1][car.startY])
           return false;
       if(car.carSize==3) 
           if(!isCellEmpty[car.startX+2][car.startY])
                return false;
   }
   return true;
   
   }
   public void updateMap(Car car){
       if (car.state.equals("h")){
           isCellEmpty[car.startX][car.startY] = false;
           map[car.startX][car.startY]= car.carNo;
           isCellEmpty[car.startX][car.startY+1] = false;
           map[car.startX][car.startY+1]= car.carNo;
           if (car.carSize == 3){
               isCellEmpty[car.startX][car.startY+2] = false;
                map[car.startX][car.startY+2]= car.carNo;
           }
       }
       else {
           isCellEmpty[car.startX][car.startY] = false;
           map[car.startX][car.startY]= car.carNo;
           isCellEmpty[car.startX+1][car.startY] = false;
           map[car.startX+1][car.startY]= car.carNo;
           if (car.carSize == 3){
               isCellEmpty[car.startX+2][car.startY] = false;
               map[car.startX+2][car.startY]= car.carNo;
           }
    }
   }
   
   private boolean[][] cloneCellEmpty() {
       
       boolean[][] a =  new  boolean[row][column];
       for (int i = 0 ; i < row ; i++ ){
            for(int j = 0 ; j < column ; j++){
                a[i][j] = isCellEmpty[i][j];
            }
       }
       return a;
   }
   
   private int[][] cloneMap() {
       int [][] a = new int[row][column];
       for (int i = 0 ; i < row ; i++ ){
            for(int j = 0 ; j < column ; j++){
                a[i][j] = map[i][j];
            }
       }
    return a;
}
   private ArrayList<Car> cloneCar() throws CloneNotSupportedException{
       ArrayList<Car> a = new ArrayList<>();
       for (Car car : carlist) {
           Car c =  (Car) car.clone();
           a.add(c);
           
       }
       return a;
   }

    public Object clone() throws CloneNotSupportedException{
        Object obj =  super.clone();
        if (obj instanceof Map){
            Map map = (Map)obj;
            map.map = this.cloneMap();
            map.isCellEmpty = this.cloneCellEmpty();
            map.carlist = this.cloneCar();
        }
        return obj;
    }
    
}
