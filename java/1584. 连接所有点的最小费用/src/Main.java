import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

    public static int get_distance(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static int prim(int[][] w,int n){
        int sum = 0;
        int[] min_dis = new int[n];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(n * n, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        HashSet<Integer> hashSet = new HashSet<>();
        min_dis[0] = 0;
        hashSet.add(0);
        for (int i = 1; i < n; ++i){
            min_dis[i] = w[i][0];
            priorityQueue.offer(new int[]{i,min_dis[i]});
        }

        while (priorityQueue.size() != 0){
            int[] first = priorityQueue.poll();
            if (hashSet.contains(first[0])) continue;
            hashSet.add(first[0]);
            sum += first[1];
            for (int i = 1; i < n; ++i){
                if (!hashSet.contains(i) && w[first[0]][i] < min_dis[i]){
                    min_dis[i] = w[first[0]][i];
                    priorityQueue.offer(new int[]{i,min_dis[i]});
                }
            }
        }
        return sum;
    }

    public static int minCostConnectPoints(int[][] points) {
        int [][]w = new int[points.length][points.length];
        int res = 0;

        for (int i = 0; i < points.length; ++i){
            for (int j = 0; j < points.length; ++j){
                if (i > j) w[i][j] = w[j][i];
                else w[i][j] = get_distance(points[i],points[j]);
            }
        }

        res = prim(w,points.length);
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
        //System.out.println(minCostConnectPoints(new int[][]{{0,0},{1,1},{1,0},{-1,1}}));
        //System.out.println(minCostConnectPoints(new int[][]{{-1000000,-1000000},{1000000,1000000}}));
        System.out.println(minCostConnectPoints(new int[][]{{0,0}}));
    }
}
