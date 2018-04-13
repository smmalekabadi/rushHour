package aifirstexe;

public class Hurestics {
    public static int heurstic(Map map){
        int count = 0 ;
        for (int i = map.carlist.get(0).startY+2 ; i < 6 ; i++)
            if(map.isCellEmpty[2][i])
                continue;
            else {
                count+=isblocked(map,map.carlist.get( map.map[2][i] - 1 ));
            }
        return count;
    }
    public static int isblocked(Map map , Car car){
        int count = 0;
        if (car.carSize == 3){

                for (int i = car.startX + 3 ; i <=5 ; i++ )
                    if (!map.isCellEmpty[i][car.startY])
                        count++;

        }
        else {
            int d = 0 ;
            int u = 0 ;
            for (int i = car.startX + 2; i <= 5; i++)
                if (!map.isCellEmpty[i][car.startY])
                    d++;
            for(int i = car.startX - 1 ; i >= 0 ; i--)
                if(!map.isCellEmpty[i][car.startY])
                    u++;
            if (map.isCellEmpty[car.startX+2][car.startY] && map.isCellEmpty[car.startX+ 3 ][car.startY] )
                count++;
            else
                count += Math.min(u,d);
        }
        return count;
    }
}
