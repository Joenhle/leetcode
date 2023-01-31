public class Main {





    public long mod = (long) (Math.pow(10,9)+7);

    public int numSub(String s) {
        int arr[] = new int[s.length()];
        arr[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < s.length(); ++i){
            if (s.charAt(i) == '1'){
                arr[i] = arr[i-1] + 1;
            }
        }
        long dp[] = new long[s.length()];
        dp[0] = arr[0];
        for (int i = 1; i < s.length(); ++i){
            dp[i] = dp[i-1] + arr[i];
        }
        return (int) (dp[s.length()]%mod);
    }

    public static void main(String[] args) {

    }
}
