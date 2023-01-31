
public class Main {

    public static int rob_1(int[] nums){
        int dp[][] = new int[nums.length][2];
        for (int i = 0; i < nums.length; ++i){
            dp[i][0] = 0;
            dp[i][1] = 0;
        }

        dp[0][1] = nums[0];
        dp[0][0] = 0;

        for (int i = 1; i<nums.length; ++i){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    public static int rob(int[] nums) {
        if( nums.length == 0 ){
            return 0;
        }else if ( nums.length == 1){
            return nums[0];
        }else {
            int temp = nums[0];
            nums[0] = 0;
            int result1 = rob_1(nums);
            nums[0] = temp;
            nums[nums.length-1] = 0;
            int result2 = rob_1(nums);
            return Math.max(result1,result2);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(rob(nums));
    }
}
