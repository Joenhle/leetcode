public class Main {

    public static int maxProfit(int[] prices, int fee) {
        if(prices.length <= 1) return 0;
        /**
         * dp[0] ??
         * dp[1] ??
         * dp[2] ???,??
         * dp[3] ???,??
         */
        int dp[] = new int[4];
        dp[0] = -prices[0];
        dp[1] = -0x3333ffff;
        dp[2] = -0x3333ffff;
        for (int i = 1; i < prices.length; ++i){
            int a,b,c,d;
            a = Math.max(dp[1],dp[3]) - prices[i];
            b = Math.max(dp[0],dp[2]) + prices[i] - fee;
            c = Math.max(dp[0],dp[2]);
            d = Math.max(dp[1],dp[3]);
            dp[0] = a;
            dp[1] = b;
            dp[2] = c;
            dp[3] = d;
        }
        int x = Math.max(dp[0],dp[1]);
        int y = Math.max(dp[2],dp[3]);
        return Math.max(x,y);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9},2));
    }
}
