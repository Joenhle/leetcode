import java.util.ArrayList;
import java.util.List;

public class Main {


    public static List<String> res = new ArrayList<>();

    public static String check(ArrayList<String> arrayList){
        String str = new String();
        for (String temp : arrayList){
            if (temp.length() > 1 && temp.charAt(0) == '0') return "";
            if (Integer.valueOf(temp) >= 0 && Integer.valueOf(temp) <= 255){
                str += "".equals(str) ? temp : "."+temp;
            }
            else
                return "";
        }
        return str;
    }

    public static void backtracking(ArrayList<String> arrayList,String arr){
        if (arrayList.size() == 4 && arr.equals("")) {
            String str = check(arrayList);
            if (!"".equals(str)) res.add(str);
        }else {
            for (int len = 1; len <= Math.min(arr.length(),3); ++len){
                ArrayList<String> temp = new ArrayList<>(arrayList);
                temp.add(arr.substring(0,len));
                backtracking(temp,arr.substring(len));
            }
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return new ArrayList<>();
        backtracking(new ArrayList<>(),s);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("101023"));
    }
}
