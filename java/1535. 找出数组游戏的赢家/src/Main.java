import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {


    public static int getWinner(int[] arr, int k) {
        int max = 0;
        for (int num : arr){
            max = Math.max(max,num);
        }

        int nums[] = new int[1000001];

        LinkedList<Integer> list = new LinkedList<>();
        for (int num : arr) list.add(num);

        if (k >= arr.length-1) return max;

        while (true){
            int a = list.removeFirst();
            int b = list.removeFirst();
            if (a >= b) {
                nums[a]++;
                if (nums[a] == k) return a;
                list.addFirst(a);
                list.addLast(b);
            }
            else {
                nums[b]++;
                if (nums[b] == k) return b;
                list.addFirst(b);
                list.addLast(a);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getWinner(new int[]{2,1,3,5,4,6,7},2));
    }
}
