import java.math.BigInteger;
import java.util.Arrays;

public class Main {


    public static long[][] ways = null;
    public static long mod = (long) (Math.pow(10,9) + 7);
    public static Long a = Long.MAX_VALUE;

    public static long getWays(int[] locations, int start, int finish, int fuel){
        if (ways[finish][fuel] != -1) return ways[finish][fuel];
        long sum = 0;
        if (finish == start) {
            sum++;
        }
        for (int i = 0; i < locations.length; ++i){
            if (i != finish && fuel >= Math.abs(locations[finish] - locations[i])){
                sum += getWays(locations,start,i,fuel - Math.abs(locations[finish] - locations[i]));
            }
        }
        ways[finish][fuel] = sum % mod;
        return sum % mod;
    }

    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        ways = new long[locations.length][201];
        for (int i = 0; i < locations.length; ++i){
            Arrays.fill(ways[i],-1);
        }

        long res = getWays(locations,start,finish,fuel) % mod;
        return (int) res;

    }

    public static void main(String[] args) {
        System.out.println(countRoutes(new int[]{99569,99784,99706,99950,99683,99955,99595,99899,99802,99968,99590,99965,99966,99850,99792,99962,99934,99622,99546,99545,99541,99751,99697,99587,99919,99700,99642,99915,99720,99746,99607,99724,99690,99558,99828,99741,99844,99887,99616,99623,99754,99721,99648,99639,99709,99649,99833,99863,99730,99780,99525,99609,99637,99781,99619,99548,99728,99652,99744,99900,99922,99969,99610,99892,99845,99985,99549,99654,99657,99535,99612,99755,99742,99798,99838,99676,99553,99601,99989,99606,99944,99611
        },42,62,98));
    }
}
