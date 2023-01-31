

public class Main {


    public static int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[3001];
        dp[nums[0]+1000] = 1;
        dp[-nums[0]+1000] += 1;
        for (int i = 1; i < nums.length; ++i){
            int[] next = new int[3001];
            for (int j = -1000; j <= 1000; ++j){
                if (dp[j+1000] > 0){
                    next[j + nums[i] + 1000] += dp[j + 1000];
                    next[j - nums[i] + 1000] += dp[j + 1000];
                }
            }
            dp = next;
        }

        if (S > 1000 || S < -1000) return 0;
        return dp[S+1000];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53},1000));
    }
}
