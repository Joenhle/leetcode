public class Main {


    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int dp[] = new int[arr.length];
        for (int i = 2; i < arr.length; ++i){
            dp[i] = dp[i-1];
            for (int j = 0; j <= i-2; ++j){
                for (int k = j + 1; k <= i-1; ++k){
                    if (Math.abs(arr[j]-arr[k])<=a && Math.abs(arr[k]-arr[i])<=b && Math.abs(arr[j]-arr[i])<=c){
                        dp[i]++;
                    }
                }
            }
        }
        return dp[arr.length-1];
    }


    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3,0,1,1,9,7},7,2,3));
    }
}
