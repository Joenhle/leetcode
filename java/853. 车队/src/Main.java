import java.util.*;

public class Main {

    public static int carFleet(int target, int[] position, int[] speed) {
        double arr[][] = new double[position.length][2];
        for (int i = 0; i < position.length; ++i){
            arr[i][0] = position[i];
            arr[i][1] = (double) (target-position[i])/speed[i];
        }
        Arrays.sort(arr,(o1,o2) -> (int) (o1[0]-o2[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = arr.length-1; i >= 0; --i){
            if (stack.isEmpty()){
                stack.push(arr[i][1]);
            }else {
                Double top = stack.peek();
                if (arr[i][1] > top){
                    stack.push(arr[i][1]);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(carFleet(10,new int[]{},new int[]{}));
    }
}


