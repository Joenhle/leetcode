import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public static int get(int[] nums1, int[] nums2){
        HashMap<Long,Integer> hashMap = new HashMap<>();
        for (int i = 0 ;i < nums1.length; ++i){
            if (hashMap.containsKey((long)nums1[i]*nums1[i])){
                int temp = hashMap.get((long)nums1[i]*nums1[i]);
                temp++;
                hashMap.put((long)nums1[i]*nums1[i],temp);
            }else {
                hashMap.put((long)nums1[i]*nums1[i],1);
            }
        }

        int res = 0;
        for (int i = 0; i < nums2.length; ++i){
            for (int j = i + 1; j < nums2.length; ++j){
                if (hashMap.containsKey((long)nums2[i]*nums2[j])){
                    res += hashMap.get((long)nums2[i]*nums2[j]);
                }
            }
        }
        return res;
    }

    public static int numTriplets(int[] nums1, int[] nums2) {
        return get(nums1,nums2)+get(nums2,nums1);
    }

    public static void main(String[] args) {
        System.out.println(numTriplets(new int[]{1,1},new int[]{1,1,1}));
    }

}
