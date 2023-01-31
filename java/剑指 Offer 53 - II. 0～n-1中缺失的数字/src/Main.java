public class Main {


    public static int missingNumber(int[] nums) {
        int l = 0, r = nums.length-1;
        while (r-l!=1){
            int mid = (l+r)/2;
            if (mid == nums[mid]){
                l = mid;
            }else {
                r = mid;
            }
        }
        return l+1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0}));
    }
}
