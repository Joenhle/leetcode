import java.util.Arrays;

public class Main {

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int pre = 0;
        for (int i = 0; i <= nums.length; i++){
            for (int j = pre; j < nums.length; ++j){
                if (nums[j] >= i){
                    pre = j;
                    if (nums.length - j == i){
                        return i;
                    }else {
                        break;
                    }
                }else {
                    continue;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3,6,7,7,0}));
    }
}
