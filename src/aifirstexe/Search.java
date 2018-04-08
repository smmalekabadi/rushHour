/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aifirstexe;

import java.util.*;
import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * 
 */
public class Search {
    public Map map;
    public Search(Map map){
        this.map = map;
    
    }
    public Node gbfs() throws CloneNotSupportedException {
        Node intial = new Node( map, null,0,0,0,null,0);
        ArrayList<Node> fringe = new ArrayList<Node>();
        fringe.add(intial);
        int i=0;
        while (!fringe.isEmpty()){

            if (!isNodeRepeated(fringe,fringe.get(i),i)){
                fringe.addAll(i+1,makeChild( fringe.get(i) ,"bgfs"));
                Collections.sort(fringe);
                if (fringe.get(i).map.map[2][5] == 1 ){ // goal

                    for(int j = 0 ; j < 6 ; j++ ){
                        for(int k = 0 ; k < 6 ; k++){
                            System.out.print(fringe.get(i).map.map[j][k]);}
                        System.out.println("");
                    }
                    return fringe.get(i);
                }
            }
            i++;
        }
        return null;
    }
    public Node[] bds() throws CloneNotSupportedException{
      Node node =  bfs();
      Node ans[]= new Node[2];
      Node intial = new Node( map, null,0,0,0,null,0);
        ArrayList<Node> fringe1 = new ArrayList<Node>();
        ArrayList<Node> fringe2 = new ArrayList<Node>();
        fringe1.add(intial);
        fringe2.add(node);
        int i=0; 
        while (!fringe1.isEmpty()){
            if (!isNodeRepeated(fringe1,fringe1.get(i),i)){
                Node match = findNodeOnList(fringe1.get(i), fringe2);
                if(match != null){
                     ans[0] = fringe1.get(i);
                     ans[1] = match;
                     for(int j = 0 ; j < 6 ; j++ ){
                        for(int k = 0 ; k < 6 ; k++){
                             System.out.print(fringe1.get(i).map.map[j][k]);
                        }System.out.println("");
                     }
                     for(int j = 0 ; j < 6 ; j++ ){
                        for(int k = 0 ; k < 6 ; k++){
                             System.out.print(match.map.map[j][k]);
                        }System.out.println("");
                     }
                     return ans;
                }
                fringe1.addAll(makeChild(fringe1.get(i),"ucs"));
            }
            if (!isNodeRepeated(fringe2,fringe2.get(i),i)){
                Node match = findNodeOnList(fringe2.get(i), fringe1);
                if(match != null){
                    ans[0] = match;
                    ans[1] = fringe2.get(i);
                    for(int j = 0 ; j < 6 ; j++ ){
                        for(int k = 0 ; k < 6 ; k++){
                             System.out.print(fringe2.get(i).map.map[j][k]);}
                        System.out.println("");
                     }
                    for(int j = 0 ; j < 6 ; j++ ){
                        for(int k = 0 ; k < 6 ; k++){
                             System.out.print(match.map.map[j][k]);
                        }System.out.println("");
                     }
                    return ans;
                }
                fringe2.addAll(makeChild(fringe2.get(i),"ucs"));
            }
            i++;
         }
    return null;
    }
    public Node ucs() throws CloneNotSupportedException{
        Node intial = new Node( map, null,0,0,null,0);
        ArrayList<Node> fringe = new ArrayList<Node>();
        ArrayList<Node> visited = new ArrayList<Node>();
        fringe.add(intial);
        int i = 0;
        int count = 0;
        while (!fringe.isEmpty()){

            if (findNodeOnList(fringe.get(i),visited) == null ){

                fringe.addAll(makeChild(fringe.get(i),"ucs"));
                visited.add(fringe.get(i));
                Collections.sort(fringe);
                System.out.println(count++);
                if (fringe.get(i).map.map[2][5] == 1 ){ // goal

                    for(int j = 0 ; j < 6 ; j++ ){
                        for(int k = 0 ; k < 6 ; k++){
                            System.out.print(fringe.get(i).map.map[j][k]);}
                        System.out.println("");
                    }
                    return fringe.get(i);
                }

                i=0;
            }
            else
                i++;
        }
        return null;
    }
    public Node ids(int itrDepth) throws CloneNotSupportedException{
        Node intial = new Node( map, null,0,0,null,0);
        ArrayList<Node> fringe = new ArrayList<Node>();
        fringe.add(intial);
        int j = 0; 
        for (;fringe.size()>j;){
            
                if (!isNodeRepeated(fringe,fringe.get(j),j)){
                    if (fringe.get(j).depth < itrDepth)
                        fringe.addAll(j+1,makeChild( fringe.get(j) ,"ucs"));
                    else
                        fringe.addAll(makeChild(fringe.get(j),"ucs"));

                    if (fringe.get(j).map.map[2][5] == 1 ){ // goal
                     
                     for(int l = 0 ; l < 6 ; l++ ){
                        for(int k = 0 ; k < 6 ; k++){
                             System.out.print(fringe.get(j).map.map[l][k]);}
                        System.out.println("");
                     }
                     return fringe.get(j); 
                 }

                }
                j++;
        }    
    return null;
    }
    
    public Node dfs() throws CloneNotSupportedException{
        Node intial = new Node( map, null,0,0,null,0);
        ArrayList<Node> fringe = new ArrayList<Node>();
        fringe.add(intial);
        int i = 0;
        int count =0;
        while (!fringe.isEmpty()){
            
            if (!isNodeRepeated(fringe,fringe.get(i),i)){

                fringe.addAll(i+1,makeChild( fringe.get(i) ,"ucs"));
                System.out.println(count++);
                if (fringe.get(i).map.map[2][5] == 1 ){ // goal
                     
                     for(int j = 0 ; j < 6 ; j++ ){
                        for(int k = 0 ; k < 6 ; k++){
                             System.out.print(fringe.get(i).map.map[j][k]);}
                        System.out.println("");
                     }
                     return fringe.get(i); 
                 }
                }
            i++;
        }
    return null;
    }
    
    public Node bfs () throws CloneNotSupportedException{
        Node intial = new Node( map, null,0,0,null,0);
        ArrayList<Node> fringe = new ArrayList<Node>();
        fringe.add(intial);
        int i = 0;
        int count = 0;
        while (!fringe.isEmpty()){
            
            if (!isNodeRepeated(fringe,fringe.get(i),i)){
               
                 fringe.addAll(makeChild(fringe.get(i),"ucs"));
                System.out.println(count++);
                 if (fringe.get(i).map.map[2][5] == 1 ){ // goal
                     
                     for(int j = 0 ; j < 6 ; j++ ){
                        for(int k = 0 ; k < 6 ; k++){
                             System.out.print(fringe.get(i).map.map[j][k]);}
                        System.out.println("");
                     }
                     return fringe.get(i); 
                 }
                }
            i++;
        }
        return null;
    }
    public ArrayList<Node> makeChild(Node node,String type) throws CloneNotSupportedException{
        ArrayList<Node> fringe = new ArrayList<Node>();
        System.out.println("father map");
         for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(node.map.map[i][j] + "  ");
                }
                System.out.println(" ");
        }
         
        for (Car car : node.map.carlist) {
            for (int count = 1; count < 5 ; count++ ){
            if (car.state.equals("h")){  ///move fw bw
                if (car.canMove(node.map, "l",count)){
                    Car c =  (Car) car.clone();
                    Map newMap = new Map();
                    newMap = (Map) node.map.clone();
                    c.doMove(newMap, "l", count);
                    newMap.carlist.set(c.carNo-1, c) ;
                    fringe.add(new Node(newMap, node,node.depth+1,generateCost(newMap,c,node,type,"l") ,"l",count));
                }
                if(car.canMove(node.map, "r",count)){
                    Car c =  (Car) car.clone();
                    Map newMap = new Map();
                    newMap = (Map) node.map.clone();
                    c.doMove(newMap, "r", count);
                    newMap.carlist.set(c.carNo-1, c) ;
                    fringe.add(new Node(newMap, node,node.depth+1,generateCost(newMap,c,node,type,"r"),"r",count));
                }
            }
            else {
                if (car.canMove(node.map, "u",count)){
                    Car c =  (Car) car.clone();
                    Map newMap = new Map();
                    newMap = (Map) node.map.clone();
                    c.doMove(newMap, "u", count);
                    newMap.carlist.set(c.carNo-1, c) ;
                    fringe.add(new Node(newMap, node,node.depth+1,generateCost(newMap,c,node,type,"u"),"u",count));
                    }
                if(car.canMove(node.map, "d",count)){
                    Car c =  (Car) car.clone();
                    Map newMap = new Map();
                    newMap = (Map) node.map.clone();
                    c.doMove(newMap, "d", count);
                    newMap.carlist.set(c.carNo-1, c) ;
                    fringe.add(new Node(newMap, node,node.depth+1,generateCost(newMap,c,node,type,"d"),"d",count));
                }
            }
            }
        }
        return fringe;
        
    }
    
    public boolean isNodeRepeated(ArrayList<Node> fringe , Node test, int ii){
        if (fringe.size() == 1 )
            return false;
        int a = 0 ; 
        for (int i = 0 ; i < ii-1 ; i++ ) {
            for(int j = 0 ; j < 6 ; j++ ){
                for(int k = 0 ; k < 6 ; k++){
                    if (fringe.get(i).map.map[j][k] != test.map.map[j][k])
                        a=1;
                }
            }
            
            
            if (a==0)
                return true;
            a=0;
        }  
        return false;
    }
    public Node findNodeOnList(Node node, ArrayList<Node> list){
//    if (list.size() == 1 )
//            return null;
        int a = 0 ; 
       
        for (Node node1 : list) {
            for(int j = 0 ; j < 6 ; j++ ){
                for(int k = 0 ; k < 6 ; k++){
                    if ( node1.map.map[j][k] != node.map.map[j][k] )
                        a=1;
                }
            }
            if (a==0)
                return node1;
            a=0;
        }
        return null;
    }
    public int generateCost(Map map,Car car,Node node, String type,String dir){

        if (type.equals("ucs")){
            if (dir.equals("l") || dir.equals("u"))
                return node.cost + car.carSize;
            else
                return node.cost + car.carSize - 1;
        }
        else if (type.equals("gbfs")){
            return Hurestics.heurstic(map);
        }
        else
            return node.cost + Hurestics.heurstic(map);
    }
    
}
