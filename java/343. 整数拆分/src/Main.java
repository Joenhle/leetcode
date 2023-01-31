

public class Main {

    public static int integerBreak(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;

        for (int i =3; i <= n; ++i){
            int ans = i;
            for (int j = 1; j <= i/2; ++ j){
                ans = Math.max(Math.max(dp[j]*dp[i-j],j*(i-j)),ans);
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(8));
    }
}
