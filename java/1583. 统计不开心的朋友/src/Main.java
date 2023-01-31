import java.util.HashMap;
import java.util.HashSet;

public class Main {


    public static HashMap<Integer,Integer> hashMap = new HashMap<>();
    public static HashSet<Integer> hashSet = new HashSet<>();

    public static boolean is_unhappy(int[][] preferences, int i, int friend){
        boolean unhappy = false;
        int pair = hashMap.get(friend);
        for (int next : preferences[friend]){
            if (next == pair) break;
            if (next == i) {
                unhappy = true;
                break;
            }
        }
        return unhappy;
    }

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        for (int[] pair : pairs){
            hashMap.put(pair[0],pair[1]);
            hashMap.put(pair[1],pair[0]);
        }

        for (int i = 0; i < n; ++i){
            if (hashSet.contains(i)) continue;
            int pair = hashMap.get(i);
            for (int friend : preferences[i]){
                if (friend == pair) break;
                if (is_unhappy(preferences,i,friend)){
                    hashSet.add(i);
                    hashSet.add(friend);
                }
            }
        }

        return hashSet.size();
    }

    public static void main(String[] args) {
        //System.out.println(unhappyFriends(4,new int[][]{{1,2,3},{3,2,0},{3,1,0},{1,2,0}},new int[][]{{0,1},{2,3}}));
        //System.out.println(unhappyFriends(2,new int[][]{{1},{0}},new int[][]{{1,0}}));
        System.out.println(unhappyFriends(4,new int[][]{{1,3,2},{2,3,0},{1,3,0},{0,2,1}},new int[][]{{1,3},{0,2}}));
    }

}
