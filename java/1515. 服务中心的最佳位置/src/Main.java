public class Main {

    public double getDistance(double x, double y,int [][]positions){
        double ans = 0.0;
        for (int[] pos: positions){
            ans += Math.sqrt(Math.pow(x-pos[0],2) + Math.pow(y - pos[1],2));
        }
        return ans;
    }

    public double getOptimal(double x,int[][] positions){
        double l = 0;
        double r = 100;
        double minWidth = 1e-7;

        while (r - l >= minWidth){
            double yl = (2 * l + r) / 3;
            double yr = (l + 2 * r) / 3;
            if (getDistance(x,yl,positions) > getDistance(x,yr,positions)){
                l = yl;
            }else {
                r = yr;
            }
        }
        return getDistance(x,l,positions);
    }

    public double getMinDistSum(int[][] positions) {
        double l = 0;
        double r = 100;
        double minWidth = 1e-7;

        while (r -l >= minWidth){
            double xl = (2 * l + r) / 3;
            double xr = (l + 2 * r) / 3;
            if (getOptimal(xl,positions) > getOptimal(xr,positions)){
                l = xl;
            }else {
                r = xr;
            }
        }
        return getOptimal(l,positions);
    }


    public static void main(String[] args) {

    }
}
