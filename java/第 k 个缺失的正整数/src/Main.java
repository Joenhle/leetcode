

public class Main {

    public int findKthPositive(int[] arr, int k) {
        int nums[] = new int[1000+k+1];
        for (int i : arr){
            nums[i] = 1;
        }
        int res = 0;
        for (int i = 1 ;i <= 1000+k; ++i){
            if (nums[i] == 0){
                res++;
                if (res == k){
                    return nums[i];
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
