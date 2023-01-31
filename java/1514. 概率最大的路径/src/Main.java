import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double ans[] = new double[n];
        List<List<Pair>> arraylist = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            arraylist.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; ++i){
            ArrayList<Pair> node1 = (ArrayList<Pair>) arraylist.get(edges[i][0]);
            ArrayList<Pair> node2 = (ArrayList<Pair>) arraylist.get(edges[i][1]);
            node1.add(new Pair(succProb[i],edges[i][1]));
            node2.add(new Pair(succProb[i],edges[i][0]));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(1,start));
        ans[start] = 1;

        while (!queue.isEmpty()){
            Pair cur = queue.poll();
            int node = cur.node;
            for (Pair next : arraylist.get(node)){
                if (ans[next.node] < ans[node]*next.probability){
                    ans[next.node] = ans[node]*next.probability;
                    queue.offer(new Pair(ans[next.node],next.node));
                }
            }
        }
        return ans[end];
    }

    static class Pair implements Comparable<Pair>{
        double probability;
        int node;

        Pair(double probability,int node){
            this.probability = probability;
            this.node = node;
        }

        @Override
        public int compareTo(Pair pair2) {
            if (this.probability == pair2.probability){
                return this.node - pair2.node;
            }else {
                return this.probability > pair2.probability ? -1 : 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(maxProbability(3,new int[][]{{0,1},{1,2},{0,2}},new double[]{0.5,0.5,0.2},0,2));
    }

}


