import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static ArrayList<int[]> arrayList = new ArrayList<>();

    public static List<String> maxNumOfSubstrings(String s) {
        int index[][] = new int[26][2];
        for (int i = 0; i < 26; ++i){
            char ch = (char) ('a' + i);
            index[i][0] = s.indexOf(ch);
            index[i][1] = s.lastIndexOf(ch);
        }


        for (int i = 0; i < 26; ++i){
            int l  = index[i][0],r = index[i][1];
            if (l != -1 && l != r){
                boolean flag = true;
                HashSet<Character> hashSet = new HashSet<>();
                while (flag){
                    flag = false;
                    for (int j = l; j <= r; ++j){
                        char ch = s.charAt(j);
                        if (hashSet.contains(ch)) continue;
                        hashSet.add(ch);
                        int a[] = index[ch-'a'];
                        if (a[0] < l){
                            l = a[0];
                            flag = true;
                        }
                        if (a[1] > r){
                            r = a[1];
                            flag = true;
                        }
                    }
                    index[i][0] = l;
                    index[i][1] = r;
                }
            }
        }



        for (int i = 0; i < 26; ++i){
            if (index[i][0] != -1){
                arrayList.add(new int[]{index[i][0],index[i][1]});
            }
        }


        arrayList.add(new int[]{0,s.length()-1});
        arrayList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]){
                    int l1 = a[1]-a[0];
                    int l2 = b[1]-b[0];
                    return l1 - l2;
                }else return a[1] - b[1];

            }
        });

        List<String> res = new ArrayList<>();
        int right = -1;
        for (int[] arr : arrayList){
            String str = s.substring(arr[0],arr[1]+1);
            if (arr[0] > right) {
                res.add(str);
                right = arr[1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxNumOfSubstrings("abca").toString());
    }
}

