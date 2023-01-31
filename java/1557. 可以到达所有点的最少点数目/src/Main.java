import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int en_degree[] = new int[n];
        for (List<Integer> edge : edges){
            int to = edge.get(1);
            en_degree[to]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            if (en_degree[i] == 0)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
