import java.util.Arrays;

public class Main {

    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int diff[] = new int[nums.length];
        for (int i = 0; i < nums.length-1; ++i){
            diff[i] = nums[i+1] - nums[i];
        }
        int dp[] = new int[2];

        for (int i = 0; i < diff.length; ++i){
            if (diff[i] > 0){
                dp[0] = dp[1] + 1;
            }else if (diff[i] < 0){
                dp[1] = dp[0] + 1;
            }
        }
        return Math.max(dp[0],dp[1])+1;
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
