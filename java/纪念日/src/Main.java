import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static int max = 0;
    public static int loc = 0;

    public static String getone(String str){
        HashMap<String,Integer> hashMap = new HashMap<>();
        int start = 0;
        int end = start + 10;
        while (end <= str.length()){
            String temp = str.substring(start,end);
            if (check(temp)){
                if (hashMap.containsKey(temp)){
                    int num = hashMap.get(temp);
                    hashMap.put(temp,num+1);
                    if (num+1 > max){
                        max = num+1;
                        loc = start;
                    }
                }else {
                    hashMap.put(temp,1);
                }
            }
            start += 8;
            end += 8;
        }
        return str.substring(loc,loc+10);
    }

    public static boolean check(String str){
        String[] arr = str.split("-");
        int temp[] = new int[3];
        for (int i = 0; i < arr.length; ++i){
            if (arr[i].charAt(0)=='0'){
                temp[i] = Integer.valueOf(arr[i].substring(1));

            }else {
                temp[i] = Integer.valueOf(arr[i]);
            }
        }
        if(temp[2] >= 2001 && temp[2] <= 2020){
            if (temp[1]==2){
                if (temp[2]%4==0 && temp[2]%100!=0){
                    if (temp[0]>=1 && temp[0]<=29){
                        return true;
                    }
                }else {
                    if (temp[0]>=1 && temp[0]<=28){
                        return true;
                    }
                }
            }else if (temp[1]==1 || temp[1]==3 || temp[1]==5 || temp[1]==7 || temp[1]==8 || temp[1]==10 || temp[1]==12){
                if (temp[0] >= 1 && temp[0] <= 31){
                    return true;
                }
            }else {
                if (temp[0] >= 1 && temp[0] <= 30){
                    return true;
                }
            }

        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(getone(str));
    }
}
