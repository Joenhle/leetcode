public class Main {

    public static long mod = (long) (Math.pow(10,9)+7);

    public static int numOfSubarrays(int[] arr) {
        long []sum = new long[arr.length+1];
        long dp[] = new long[arr.length];
        long odd = 0;
        long even = 0;
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; ++i)
            sum[i] = sum[i-1] + arr[i];

        if (arr[0] % 2 == 0) {
            even++;
        }
        else {
            dp[0] = 1;
            odd++;
        }


        for (int i = 1; i < arr.length; ++i){
            dp[i] = dp[i-1] + sum[i]%2;
            if (sum[i] % 2 == 0){
                dp[i] += odd;
                even++;
            }else {
                dp[i] += even;
                odd++;
            }
        }

        return (int) (dp[arr.length-1] % mod);
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{6}));
    }
}
