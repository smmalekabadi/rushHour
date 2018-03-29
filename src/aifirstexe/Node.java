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
public class Node implements Comparable<Node>{
    public Node parent;
    public Map map;
    public int depth;
    public int cost = 1;
    public int carMovesNO;
    public int carMoveDistance;
    public String dir;
    public Node(Map map, Node parent,int depth,int carMovesNO,String dir,int carMoveDistance){
        this.parent = parent;
        this.map = map;
        this.depth=depth;
        this.carMovesNO=carMovesNO;
        this.carMoveDistance= carMoveDistance;
        this.dir=dir;
    }
    public Node(Map map, Node parent,int depth,int cost,int carMovesNO,String dir,int carMoveDistance){
        this.parent = parent;
        this.map = map;
        this.depth=depth;
        this.cost=cost;
        this.carMovesNO=carMovesNO;
        this.carMoveDistance= carMoveDistance;
        this.dir=dir;
    }

    @Override
    public int compareTo(Node o) {
        int compare = o.cost;
        return this.cost - compare;
    }
}
