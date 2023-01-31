import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static int get_step(int num){
        int step = 0;
        while (num != 1){
            if (num % 2 == 0){
                num = num/2;
            }else {
                num = 3 * num + 1;
            }
            step++;
        }
        return step;
    }

    public static int getKth(int lo, int hi, int k) {
        int arr[][] = new int[hi - lo + 1][2];
        for (int i = 0; i < arr.length; ++i){
            arr[i][0] = get_step(lo+i);
            arr[i][1] = lo + i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });
        return arr[k-1][1];
    }

    public static void main(String[] args) {
        System.out.println(getKth(1,1000,777));
    }
}
