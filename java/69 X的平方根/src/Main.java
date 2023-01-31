public class Main {


    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
//        for (int i = 0;  i<= 100; ++i){
//            System.out.println(Integer.toString(i)+" "+Integer.toString(mySqrt(i)));
//        }
    }
}
