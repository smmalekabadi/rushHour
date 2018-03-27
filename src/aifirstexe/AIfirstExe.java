/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aifirstexe;

import java.io.*;

/**
 *
 * @author Taknovin
 */
public class AIfirstExe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException, UnsupportedEncodingException, FileNotFoundException, IOException {
        
//        Map map = new Map();
//        Car c = new Car(1,  2, 1, "h", 2 );
//        Car c1 = new Car(2, 0, 0, "h" , 2);
//        Car c2 = new Car(3, 1, 0, "v" , 3);
//        Car c3 = new Car(4, 5, 0, "h" , 3);
//        Car c4 = new Car(5, 3, 2, "v" , 2);
//        Car c5 = new Car(6, 0, 3, "v" , 3);
//        Car c6 = new Car(7, 3, 3, "h" , 3);
//        Car c7 = new Car(8, 4, 4, "v" , 2);
//        
//        
//            map.addCarToMap(c);
//            map.addCarToMap(c1);
//            map.addCarToMap(c2);
//            map.addCarToMap(c3);
//            map.addCarToMap(c4);
//            map.addCarToMap(c5);
//            map.addCarToMap(c6);
//            map.addCarToMap(c7);
    
//        Map map = new Map();
//        Car c = new Car(1,  2, 0, "h", 2 );
//        Car c1 = new Car(2, 3, 0, "v" , 2);
//        Car c2 = new Car(3, 3, 1, "h" , 3);
//        Car c3 = new Car(4, 4, 1, "h" , 2);
//        Car c4 = new Car(5, 4, 3, "v" , 2);
//        Car c5 = new Car(6, 0, 2, "v" , 3);
//        Car c6 = new Car(7, 0, 3, "h" , 2);
//        Car c7 = new Car(8, 1, 3, "v" , 2);
//        Car c8 = new Car(9, 0, 5, "v" , 3);
//
//            map.addCarToMap(c);
//            map.addCarToMap(c1);
//            map.addCarToMap(c2);
//            map.addCarToMap(c3);
//            map.addCarToMap(c4);
//            map.addCarToMap(c5);
//            map.addCarToMap(c6);
//            map.addCarToMap(c7);
//            map.addCarToMap(c8);
//

//        Map map = new Map();
//        Car c = new Car(1,  2, 0, "h", 2 );
//        Car c1 = new Car(2, 0, 0, "v" , 2);
//        Car c2 = new Car(3, 3, 0, "h" , 3);
//        Car c3 = new Car(4, 4, 2, "v" , 2);
//        Car c4 = new Car(5, 3, 3, "v" , 2);
//        Car c5 = new Car(6, 1, 3, "v" , 2);
//        Car c6 = new Car(7, 0, 2, "h" , 3);
//        Car c7 = new Car(8, 1, 4, "v" , 3);
//        Car c8 = new Car(9, 4, 4, "h" , 2);
//
//        map.addCarToMap(c);
//        map.addCarToMap(c1);
//        map.addCarToMap(c2);
//        map.addCarToMap(c3);
//        map.addCarToMap(c4);
//        map.addCarToMap(c5);
//        map.addCarToMap(c6);
//        map.addCarToMap(c7);
//        map.addCarToMap(c8);
//        Reader r  = new BufferedReader(new InputStreamReader(new FileInputStream(("map.txt"))));
        Map map = new Map();
        Car c = new Car(1,  2, 1, "h", 2 );
        Car c1 = new Car(2, 0, 0, "v" , 3);
        Car c2 = new Car(3, 0, 2, "h" , 3);
        Car c3 = new Car(4, 3, 0, "h" , 3);
        Car c4 = new Car(5, 1, 3, "v" , 2);
        Car c5 = new Car(6, 3, 3, "v" , 2);
        Car c6 = new Car(7, 4, 2, "v" , 2);
        Car c7 = new Car(8, 5, 3, "h" , 2);
        Car c8 = new Car(9, 1, 4, "v" , 3);

        map.addCarToMap(c);
        map.addCarToMap(c1);
        map.addCarToMap(c2);
        map.addCarToMap(c3);
        map.addCarToMap(c4);
        map.addCarToMap(c5);
        map.addCarToMap(c6);
        map.addCarToMap(c7);
        map.addCarToMap(c8);
        /*
1 3 4 h 2
2 1 1 h 2
3 4 1 v 2
4 5 2 h 2
5 1 3 v 3
6 1 5 v 2
7 1 6 v 3
8 4 4 v 3
9 4 5 h 2
* */
// 1 3 1 h 2
//2 4 1 v 2
//3 4 2 h 3
//4 5 2 h 2
//5 5 4 v 2
//6 1 3 v 3
//7 1 4 h 2
//8 2 4 v 2
//9 1 6 v 3
//            c.doMove(map, "l", 1);
//            c1.doMove(map, "u", 1);
//            c1.doMove(map, "d", 1);
//            c1.doMove(map, "u", 1);
//            c1.doMove(map, "d", 1);
//            c1.doMove(map, "d", 1);
//        
//           
//            c.doMove(map, "r", 1);
//            c4.doMove(map, "u", 1);
            
           
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(map.map[i][j] + "  ");
                    
                }
                System.out.println(" ");
        }
        // TODO code application logic here
        
        Search s = new Search(map);
        
        String moves[]= new String[1000];
        int i = 0;
        Node node = s.bfs();
        while(node.parent !=null){
            moves[i] = node.carMovesNO +" "+node.dir+" "+ 1 ; 
            node = node.parent;
            i++;
            System.out.println(i);
        }
        PrintWriter wr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("filename2.txt"), "utf-8")));
        
     
        for(;i > 0 ;){
            System.out.println(moves[i-1]);
            wr.println(moves[i-1]);
            i--;
        }
         wr.close();
        
//test t = new test();
// test t2 = (test) t.clone();
//    t2.a =  6789;
//        System.out.println(t.a);
//        System.out.println(t2.a);
        
    }
    
}
