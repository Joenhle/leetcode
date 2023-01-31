public class Main {


    public static int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        int dp[] = new int[amount+1];
        for (int i = 0; i < coins.length; ++i){
            for (int j = 1; j <= amount; ++j){
                if (j - coins[i] == 0){
                    dp[j] += 1;
                }else if (j - coins[i] > 0){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(0,new int[]{10}));
    }
}
