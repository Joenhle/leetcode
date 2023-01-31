public class Main {

    public static int len[] = null;
    public static void init(int n){
        len = new int[n+1];
        if (n == 0) return;
        len[1] = 1;
        for (int i = 2; i <= n; ++i){
            len[i] = 2*len[i-1] + 1;
        }
    }

    public static char invert(char c){
        return c == '1' ? '0' : '1';
    }

    public static char findKthBit(int n, int k) {
        init(n);
        if (n == 1) return '0';
        if (k <= len[n-1]){
            return findKthBit(n-1,k);
        }else if (k == len[n-1]+1){
            return '1';
        }else {
            int new_k = len[n] - k + 1;
            return invert(findKthBit(n-1,new_k)) ;
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(2,3));
    }
}
