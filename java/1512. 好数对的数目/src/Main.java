public class Main {

    public int numIdenticalPairs(int[] nums) {
        int arr[] = new int[101];
        int cnt = 0;
        for(int i = 0; i < nums.length; ++i){
            arr[nums[i]]++;
        }
        for (int i = 1; i <= 100; ++i){
            if (arr[i] > 1){
                cnt += arr[i]*(arr[i]-1)/2;
            }
        }
        return cnt;
    }

}
