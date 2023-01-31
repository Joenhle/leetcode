import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Main {

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; ++i){
            sum += mat[i][i];
        }
        for (int i = 0; i < mat.length; ++i){
            sum += mat[i][mat.length - 1 - i];
        }
        if (mat.length % 2 == 1){
            sum -= mat[mat.length/2][mat.length/2];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(diagonalSum(new int[][]{{5}}));
    }
}
