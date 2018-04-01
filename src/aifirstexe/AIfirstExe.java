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
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(("temp.txt"))));
        String line = "";
        Map map = new Map();
        try {
            System.out.println(line = r.readLine());
            while ((line = r.readLine()) != null) {
                String ars[] = line.split(" ");
                Car c = new Car(Integer.parseInt(ars[0]), Integer.parseInt(ars[1]) - 1
                        , Integer.parseInt(ars[2]) - 1, ars[3], Integer.parseInt(ars[4]));
                map.addCarToMap(c);

            }
        } catch (Exception e) {
            System.out.println(
                    "Unable to open file '" +
                            "'");
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(map.map[i][j] + "  ");

            }
            System.out.println(" ");
        }

        Search s = new Search(map);

        String moves[] = new String[1000];
        int i = 0;
        Node node = s.ucs();
//        Node node = node1[0];
//        Node node0 = node1[1];
        while (node.parent != null) {
            moves[i] = node.carMovesNO + " " + node.dir + " " + node.carMoveDistance;
            node = node.parent;
            i++;
            System.out.println(i);
        }
        int j = 0;
//        while (node0.parent != null) {
//            if (node0.dir.equals("l"))
//                moves[i + j] = node0.carMovesNO + " " + "r" + " " + node0.carMoveDistance;
//            else if (node0.dir.equals("r"))
//                moves[i + j] = node0.carMovesNO + " " + "l" + " " + node0.carMoveDistance;
//            else if (node0.dir.equals("u"))
//                moves[i + j] = node0.carMovesNO + " " + "d" + " " + node0.carMoveDistance;
//            else
//                moves[i + j] = node0.carMovesNO + " " + "u" + " " + node0.carMoveDistance;
//            node0 = node0.parent;
//            j++;
//            System.out.println(j);
//        }
        PrintWriter wr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("filename2.txt"), "utf-8")));
//        int  m=i;
//            for(;i > 0 ;){
//            System.out.println(moves[i-1]);
//            wr.println(moves[i-1]);
//            i--;
//        }
//            for (int k = 0 ;k < j ; k++ ){
//                System.out.println(moves[k+m]);
//                wr.println(moves[m+k]);
//            }
//
//        wr.close();

        ///bfs dfs ids
        for (; i > 0; ) {
            System.out.println(moves[i - 1]);
            wr.println(moves[i - 1]);
            i--;
        }
        wr.close();
    }
}
    

