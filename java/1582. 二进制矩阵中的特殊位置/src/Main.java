public class Main {



    public static int numSpecial(int[][] mat) {
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];
        int res = 0;
        for (int i = 0; i < mat.length; ++i){
            int sum = 0;
            for (int j = 0; j < mat[0].length; ++j){
                sum += mat[i][j];
            }
            row[i] = sum;
        }

        for (int j = 0; j < mat[0].length; ++j){
            int sum = 0;
            for (int i = 0; i < mat.length; ++i){
                sum += mat[i][j];
            }
            col[j] = sum;
        }

        for (int i = 0; i < mat.length; ++i){
            for (int j = 0; j < mat[0].length; ++j){
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    res++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }
}
