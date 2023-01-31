

public class Main {

    public static int numSquares(int n) {

        int []dp = new int[n+1];
        int []pf = new int[n+1];
        for (int i = 1; i*i <= n; ++i){
            pf[i*i] = 1;
        }

        for (int i = 1;i <= n; ++i){
            if (pf[i] == 1){
                dp[i] = 1;
            }else {
                dp[i] = i;
                for (int j = 1; j <= i/2; ++j){
                    dp[i] = Math.min(dp[i],dp[j]+dp[i-j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
