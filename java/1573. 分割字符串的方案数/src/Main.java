import java.util.ArrayList;

public class Main {

    public static long mod = (long) (Math.pow(10,9)+7);

    public static long C_n2(long n){
        return (n % 2 == 0 ? n/2*(n-1) : (n-1)/2*n)%mod;
    }

    public static int numWays(String s) {
        int[] sum = new int[s.length()];

        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == '1'){
                sum[i] = i == 0 ? 1 : sum[i-1] + 1;
            }else {
                sum[i] = i == 0 ? 0 : sum[i-1];
            }
        }
        int totle = sum[s.length()-1];
        if (totle % 3 != 0) return 0;
        if (totle == 0) return (int) C_n2(s.length()-1);
        long cut_1 = 0, cut_2 = 0;
        for (int i = 0; i < sum.length; ++i){
            if (sum[i] == totle/3){
                cut_1++;
            }else if (sum[i] == totle/3*2){
                cut_2++;
            }
        }
        return (int) (((long)cut_1 * (long)cut_2)%mod);
    }

    public static void main(String[] args) {
        System.out.println(numWays("0000"));
    }
}
