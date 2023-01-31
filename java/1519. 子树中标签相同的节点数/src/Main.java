import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
    public static int ans[] = null;

    public static void getSum(int a[], int b[]){
        for (int i = 0; i < 26; ++i){
            a[i] += b[i];
        }
    }

    public static int[] recursive(int node,String lables,int father){
        int sum[] = new int[26];
        sum[lables.charAt(node)-'a']++;
        if (hashMap.containsKey(node)) {
            ArrayList<Integer> arrayList = hashMap.get(node);
            for (int i = 0; i < arrayList.size(); ++i){
                int son = arrayList.get(i);
                if (son != father){
                    getSum(sum,recursive(son,lables,node));
                }
            }
        }
        ans[node] = sum[lables.charAt(node)-'a'];
        return sum;
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];

        for (int i = 0; i < edges.length; ++i){
            if (!hashMap.containsKey(edges[i][0])){
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(edges[i][1]);
                hashMap.put(edges[i][0],arrayList);
            }else {
                ArrayList<Integer> arrayList = hashMap.get(edges[i][0]);
                arrayList.add(edges[i][1]);
                hashMap.put(edges[i][0],arrayList);
            }
        }

        for (int i = 0; i < edges.length; ++i){
            if (!hashMap.containsKey(edges[i][1])){
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(edges[i][0]);
                hashMap.put(edges[i][1],arrayList);
            }else {
                ArrayList<Integer> arrayList = hashMap.get(edges[i][1]);
                arrayList.add(edges[i][0]);
                hashMap.put(edges[i][1],arrayList);
            }
        }

        recursive(0,labels,-1);
        return ans;
    }

    public static void main(String[] args) {
            countSubTrees(7,new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},"abaedcd");
    }
}

