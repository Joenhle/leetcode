import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList<Integer> arrayList[] = null;
    public static void init(int [][]edges){
        arrayList = new ArrayList[edges.length+1];
        for (int i = 0; i < arrayList.length; ++i)
            arrayList[i] = new ArrayList<>();
        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            arrayList[a].add(b);
            arrayList[b].add(a);
        }
    }


    public static boolean check_circle(int a, int b,int[] flag){
        if (a == b) return true;
        flag[a] = 1;
        boolean res = false;
        for (int next : arrayList[a]){
            if (flag[next] == 0){
                res = res || check_circle(next,b,flag);
            }
        }
        flag[a] = 0;
        return res;
    }



    public static int[] findRedundantConnection(int[][] edges) {
        init(edges);
        int []res = new int[2];
        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            arrayList[a].remove(arrayList[a].indexOf(b));
            if (check_circle(a,b,new int[edges.length+1])){
                res = edge.clone();
            }
            arrayList[a].add(b);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}})));
    }
}
