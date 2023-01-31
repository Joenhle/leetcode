import java.util.Arrays;
public class Main {

    public static int coinChange(int[] coins, int money) {
        if (money == 0) return 0;
        int []dp = new int[money+1];
        for (int coin : coins){
            for (int j = coin; j <= money; ++j){
                if (coin == j){
                    dp[j] = 1;
                }else if (dp[j] == 0 && dp[j - coin] != 0){
                    dp[j] = dp[j - coin] + 1;
                }else if (dp[j] != 0 && dp[j-coin] != 0){
                    dp[j] = Math.min(dp[j],dp[j-coin] + 1);
                }
            }
        }
        return dp[money] == 0 ? -1 : dp[money];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},11));
    }
}
