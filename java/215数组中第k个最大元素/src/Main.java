import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {

    public static int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        k = nums.length - k;
        while (true) {
            int partition = partition(nums, l, r);
            if (partition == k) {
                break;
            } else if (partition < k) {
                l = partition + 1;
            } else {
                r = partition - 1;
            }
        }
        return nums[k];
    }

    public static int partition(int[] nums, int l, int h) {
        Random random = new Random();
        int middle = random.nextInt(h - l + 1) + l;
        swap(nums, l, middle);

        int i = l, j = h + 1;
        while (true) {
            while (i + 1 <= h && nums[++i] < nums[l]) ;
            while (j - 1 >= l && nums[--j] > nums[l]) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i) {
            int nums[] = new int[]{-1, 0, 2};
            findKthLargest(nums, 2);
        }

    }
}
