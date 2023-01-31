public class Main {

    public static long mod = (long) (Math.pow(10,9)+7);

    public static int binarysearch(int nums[],int l ,int r, int target){
        while (l < r){
            int mid = (l + r)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int maxSum(int[] nums1, int[] nums2) {
        long []dp1 = new long[nums1.length];
        long []dp2 = new long[nums2.length];

        dp1[0] = nums1[0];
        dp2[0] = nums2[0];
        int i = 1, j = 1;
        while (dp1[nums1.length-1] == 0 || dp2[nums2.length-1] == 0){
            if (nums1[i] == nums2[j]){
                long max = Math.max(dp1[i-1],dp2[j-1]);
                dp1[i] = max + nums1[i];
                dp2[j] = max + nums2[j];
                i = i + 1 > nums1.length-1 ? nums1.length-1 : i +1;
                j = j + 1 > nums2.length-1 ? nums2.length-1 : j + 1;
            }else if ( (dp1[nums1.length-1] == 0 && nums1[i] < nums2[j]) || (dp1[nums1.length-1] == 0 && dp2[nums2.length-1] != 0)){
                dp1[i] = dp1[i-1]+nums1[i];
                int index = binarysearch(nums2,0,j,nums1[i]);
                if (index != -1){
                    dp1[i] = Math.max(dp1[i],dp2[index]);
                    dp2[index] = dp1[i];
                }
                i = i + 1 > nums1.length-1 ? nums1.length-1 : i +1;

            }else if ( (dp2[nums2.length-1]==0 && nums2[j] < nums1[i]) || (dp1[nums1.length-1] != 0 && dp2[nums2.length-1] == 0)){
                dp2[j] = dp2[j-1]+nums2[j];
                int index = binarysearch(nums1,0,i,nums2[j]);
                if (index != -1){
                    dp2[j] = Math.max(dp2[j],dp1[index]);
                    dp1[index] = dp2[j];
                }
                j = j + 1 > nums2.length-1 ? nums2.length-1 : j + 1;
            }
        }
        return (int) (Math.max(dp1[nums1.length-1],dp2[nums2.length-1])%mod);
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{2,4,5,8,10},new int[]{4,6,8,9}));
    }
}
