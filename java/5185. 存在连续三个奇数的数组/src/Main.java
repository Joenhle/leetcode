public class Main {

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        boolean a = arr[0] % 2 == 1;
        boolean b = arr[1] % 2 == 1;
        for (int i = 2; i < arr.length; ++i){
            if (arr[i] % 2== 1 && a && b){
                return true;
            }else {
                a = b;
                b = arr[i] % 2 == 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
