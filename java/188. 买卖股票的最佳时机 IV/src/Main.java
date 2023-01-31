public class Main {


    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        if (k > len/2) k = len/2;
        int [][]dp = new int[k+1][2];
        for (int i = 1; i <= k; ++i){
            dp[i][1] = -prices[0];
        }

        for (int i = 1; i < len; ++i){
            for (int j = 1; j <= k; ++j){
                dp[j][0] = Math.max(dp[j][0],dp[j][1]+prices[i]);
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0]-prices[i]);
            }
        }

        return dp[k][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{3,3,5,0,0,3,1,4}));
    }
}
