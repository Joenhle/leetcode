public class Main {


    public static int closestToTarget(int[] arr, int target) {
        int ans = 10000000;
        for (int i = 0; i < arr.length; ++i){
            int min = Math.abs(arr[i]-target);
            ans = Math.min(ans,min);
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; ++j){
                temp = temp & arr[j];
                if (Math.abs(temp-target) < min){
                    min = Math.abs(temp-target);
                    ans = Math.min(ans,min);
                }else {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(closestToTarget(new int[]{9,12,3,7,15},5));
    }
}
