public class Main {
    public static int countPrimes(int n) {
        boolean notPrime[] = new boolean[n+1];
        int count = 0;
        for (int i = 2; i < n; ++i){
            if(notPrime[i]){
                continue;
            }
            count++;
            for (long j = i*i; j < n; j += i){
                notPrime[(int) j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
