

public class Main {


    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1) return false;

        int target = sum/2;
        boolean []dp = new boolean[target+1];
        for (int i = 0; i < nums.length; ++i){
            for (int j = target; j >= 0; --j){
                if (dp[j] == true){
                    continue;
                }
                if (nums[i] == j){
                    dp[j] = true;
                }else if (nums[i] < j){
                    dp[j] = dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{23,13,11,7,6,5,5}));
    }
}
