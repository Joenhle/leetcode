import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static int n;
    public static int m;
    public static HashMap<String, LinkedList<Pair<String,String>>> hashMap = new HashMap<>();
    public static String[] ips;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        String arr[] = temp.split("  ");
        n = Integer.valueOf(arr[0]);
        m = Integer.valueOf(arr[1]);
        ips = new String[m];

        for (int i = 0; i < n; ++i) {
            temp = br.readLine();
            arr = temp.split(" ");
            String house = arr[0];
            int start = arr[1].lastIndexOf('.');
            String pre = arr[1].substring(0, start);
            String las = arr[1].substring(start + 1);
            if (hashMap.containsKey(pre)) {
                LinkedList<Pair<String,String>> ans = hashMap.get(pre);
                ans.add(new Pair<>(las,house));
                hashMap.put(pre,ans);
            } else {
                LinkedList<Pair<String,String>> ans = new LinkedList<>();
                ans.add(new Pair<>(las,house));
                hashMap.put(pre,ans);
            }
        }
        for (int i = 0; i < m; ++i){
            ips[i] = br.readLine();
        }
    }

    public static int check(String pre,String str){
        int a = Integer.valueOf(pre);
        int k1 = Integer.valueOf(str.split("/")[0]);
        int k2 = Integer.valueOf(str.split("/")[1]);
        int max = Math.max(k1,k2);
        int min = Math.min(k1,k2);
        if (a >=  min && a<= max){
            return max-min;
        }
        return -1;
    }

    public static int gethouse(String ip){

        int start = ip.lastIndexOf('.');
        String pre = ip.substring(0, start);
        String las = ip.substring(start + 1);
        Pair<String,String> result = new Pair<>("","-1");
        int max = -1;
        if (hashMap.containsKey(pre)){
            LinkedList<Pair<String,String>> linkedList = hashMap.get(pre);

            for (Pair<String,String> pair : linkedList){
                int res = check(las,pair.getKey());
                if (res !=-1 && res > max){
                    max = res;
                    result = pair;
                }
            }
        }
        return Integer.valueOf(result.getValue());
    }


    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < m; ++i){
            System.out.println(gethouse(ips[i]));
        }
    }
}
