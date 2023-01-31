import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static HashMap<Integer,Integer> hashMap = new HashMap<>();

    public static int minDays(int n) {
        if (n <= 2) return n;
        if (hashMap.containsKey(n)) return hashMap.get(n);
        int day_2 = minDays(n/2) + n%2 + 1;
        int day_3 = minDays(n/3) + n%3 + 1;
        int res = Math.min(day_2,day_3);
        hashMap.put(n,res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minDays(61455274));
    }
}
