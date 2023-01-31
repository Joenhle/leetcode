public class Main {

    /**
     * dp[0][2] ??
     * dp[1][2] ??
     * dp[2][2] ??????
     * dp[3][2] ??????
     */
    public int maxProfit(int[] prices) {
        int [][]dp = new int[4][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; ++i){
            int a1 = Math.max(dp[0][0],dp[3][0] - prices[i]);
            int a2 = Math.max(dp[0][1],Math.max(dp[1][1],dp[2][1]) - prices[i]);

            int b1 = Math.max(dp[1][0],Math.max(dp[0][0],dp[2][0])+prices[i]);
            int b2 = Math.max(dp[1][1],Math.max(dp[0][1],dp[2][1])+prices[i]);

            int c1 = Math.max(dp[2][0],dp[0][0]);
            int c2 = Math.max(dp[2][1],dp[0][1]);

            int d1 = Math.max(dp[3][0],)
        }
    }


    public static void main(String[] args) {

    }
}
