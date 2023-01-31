import java.util.Arrays;

public class Main {

    public static boolean check(int []position,int m,int distance){
        int pre = position[0];
        int cnt = 0;
        for (int i = 1; i < position.length; ++i){
            if (position[i] - pre >= distance){
                cnt++;
                pre = position[i];
                if (cnt >= m-1){
                    return true;
                }
            }
        }
        return false;
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int min = 1;
        int max = (position[len-1]-position[0])/(m-1);
        int ans = 0;
        while (min <= max){
            int mid = min + (max-min)/2;
            if (check(position,m,mid)){
                ans = mid;
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{79,74,57,22},4));
    }
}

