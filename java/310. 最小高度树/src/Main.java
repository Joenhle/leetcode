import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> arrayList[] = new ArrayList[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; ++i){
            arrayList[i] = new ArrayList<>();
        }

        HashSet<Integer> hashSet = new HashSet<>();
        int in_degree[] = new int[n];
        for (int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            arrayList[a].add(b);
            arrayList[b].add(a);
            in_degree[a]++;
            in_degree[b]++;
        }
        for (int i = 0; i < n; ++i){
            hashSet.add(i);
        }
        while (hashSet.size() > 2){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : hashSet){
                if (in_degree[num] == 1)
                    temp.add(num);
            }
            for (int delete : temp){
                hashSet.remove(delete);
                for (int next : arrayList[delete]){
                    in_degree[next]--;
                }
            }
        }

        for (int num : hashSet){
            res.add(num);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4,new int[][]{{1,0},{1,2},{1,3}}).toString());
    }
}
