import java.util.HashSet;

public class Main {

    public static void getArray(String s, String t, int []arr){
        int len = s.length();
        for (int i = 0; i < len; ++i){
            char a = s.charAt(i);
            char b = t.charAt(i);
            arr[i] = b - a >= 0 ? b - a : 26 - (a - b);
        }
    }

    public static boolean canConvertString(String s, String t, int k) {
        int len = s.length();
        if (s.length() != t.length()) return false;
        int arr[] = new int[len];
        int cnt[] = new int[26];
        HashSet<Integer> hashSet = new HashSet<>();

        getArray(s,t,arr);
        for (int i = 0; i < arr.length; ++i){
            int j = arr[i];
            if (j == 0) continue;
            if (arr[i]+cnt[j]*26 <= k && !hashSet.contains(arr[i]+cnt[j]*26)){
                hashSet.add(arr[i]+cnt[j]*26);
                cnt[j]++;
            }else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canConvertString("aab","bbb",27));
    }
}
