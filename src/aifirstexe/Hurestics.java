package aifirstexe;

public class Hurestics {
    public static int heurstic(Map map){
        int count = 0 ;
        for (int i = map.carlist.get(0).startY ; i < 6 ; i++)
            if(map.isCellEmpty[2][i])
                continue;
            else {
                count+=isblocked(map,map.carlist.get( map.map[2][i] - 1 ));
            }
        return count;
    }
    public static int isblocked(Map map , Car car){
        if (car.carNo == 1){

        }
        return 1;
    }
}
