import java.util.Arrays;

public class Main {

    /*
    public static int[] f = null;
    public static int max = 0;

    public static int find_max_height(int[][]pais,int node){
        if (f[node] != 0) return f[node];
        int res = 0;
        for (int i = 0; i < pais.length; ++i){
            if (i != node){
                if (pais[i][0] > pais[node][1]){
                    res = Math.max(res,find_max_height(pais,i));
                }
            }
        }
        f[node] = res + 1;
        max = Math.max(max,f[node]);
        return  f[node];
    }

    public static int findLongestChain(int[][] pairs) {
        f = new int[pairs.length];
        for (int i = 0; i < pairs.length; ++i){
            find_max_height(pairs,i);
        }
        return max;
    }*/

    public static int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0){
            return 0;
        }
        Arrays.sort(pairs,(a,b)->(a[0]-b[0]));
        int []dp = new int[pairs.length];
        int max = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < pairs.length; ++i){
            for (int j = 0; j < i; ++j){
                if (pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{{9,10},{-4,9},{-5,6},{-5,9},{8,9}}));
    }
}
