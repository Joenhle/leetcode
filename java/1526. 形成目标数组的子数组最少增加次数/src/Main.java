public class Main {

    public static int minNumberOperations(int[] target) {
        int []dp = new int[target.length];
        dp[0] = target[0];
        for (int i = 1; i < target.length; ++i){
            dp[i] = dp[i-1] + (target[i]-target[i-1] > 0 ? target[i]-target[i-1] : 0);
        }
        return dp[target.length-1];
    }

    public static void main(String[] args) {
       System.out.println(minNumberOperations(new int[]{1,1,1,1}));
    }
}
