

public class Main {

//    O(n^2)
//    public int lengthOfLIS(int[] nums) {
//        int max = 0;
//        int []dp = new int[nums.length];
//        dp[0] = 1;
//        for (int i = 1; i < nums.length; ++i){
//            int res = 0;
//            for (int j = 0; j < i; ++j){
//                if (nums[j] < nums[i]){
//                    res = Math.max(res,dp[j]);
//                }
//            }
//            dp[i] = res + 1;
//            max = Math.max(max,dp[i]);
//        }
//        return dp[nums.length-1];
//    }


    //O(nlogn)
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int []d = new int[nums.length+1];
        d[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; ++i){

            if (nums[i] > d[len]){
                d[++len] = nums[i];
            }else {
                int index = binary_search(d,1,len,nums[i]);
                d[index] = nums[i];
            }
        }
        return len;
    }

    public static int binary_search(int[] d,int l,int r,int cnt){

        while (l < r){
            int mid = l + (r-l)/2;
            if (cnt == d[mid]){
                return mid;
            }else if (d[mid] > cnt){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
