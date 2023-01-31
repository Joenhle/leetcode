import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int yuandian = 0;

    public static List<Double> getAngle(List<List<Integer>> points, List<Integer> location){
        List<Double> angleList = new ArrayList<>();
        for (List<Integer> point : points){
            int x = point.get(0),y = point.get(1);
            if (x - location.get(0) == 0){
                if (y == location.get(1)) {
                    yuandian++;
                    continue;
                }
                else if (y > location.get(1)){
                    angleList.add((double) 90);
                    continue;
                }
                else{
                    angleList.add((double) 270);
                    continue;
                }
            }
            double tan = (double)Math.abs(y - location.get(1))/(double) Math.abs(x - location.get(0));
            double angle = Math.toDegrees(Math.atan(tan));
            if (x < location.get(0) && y >= location.get(1)){
                angle = 180 - angle;
            }else if (x < location.get(0) && y < location.get(1)){
                angle = 180 + angle;
            }else if (x > location.get(0) && y < location.get(1)){
                angle = 360 - angle;
            }
            angleList.add(angle);

        }
        Collections.sort(angleList);
        return angleList;
    }

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        if (angle == 360) return points.size();

        List<Double> angleList = getAngle(points,location);
        int size = angleList.size();
        for (int i = 0; i < size; ++i){
            angleList.add(angleList.get(i)+360);
        }

        System.out.println(angleList.toString());

        int r = 0;
        int max = 0;
        for (int i = 0; i < size; ++i){
            while (r < angleList.size() && angleList.get(r) - angleList.get(i) <= angle){
                r++;
            }
            max = Math.max(max,r - i);
        }

        return max+yuandian;
    }

    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        p1.add(2);
        p1.add(1);
        points.add(p1);
        List<Integer> p2 = new ArrayList<>();
        p2.add(2);
        p2.add(2);
        points.add(p2);
        List<Integer> p3 = new ArrayList<>();
        p3.add(3);
        p3.add(4);
        points.add(p3);
        List<Integer> p4 = new ArrayList<>();
        p4.add(1);
        p4.add(1);
        points.add(p4);

        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);

        System.out.println(visiblePoints(points,90,location));
    }
}
