public class Main {


    public static int getWeiShu(int n){
        int num = 0;
        for (int i = 0; i < 32; ++i){
            if (((1 << i) & n) != 0){
                num = i+1;
            }
        }
        return num;
    }

    public static int minimumOneBitOperations(int n) {
        String str = new String();
        for (int i = 0; i < 32; ++i){
            if ()
        }
    }

    public static void main(String[] args) {

    }


}
