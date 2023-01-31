import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<List<Integer>> arrayLists = new ArrayList<>();

    public static void addList(int nums[],int a[]){
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < a.length; ++i){
            for (int j = 0; j < a.length; ++j){
                if (i == a[j]){
                    temp.add(nums[j]);
                }
            }
        }
        arrayLists.add(temp);
    }

    public static void backtracking(int nums[],int a[],int b[],int k){
        for (int i = 0; i < nums.length; ++i){
            if (b[i] == 0){
                b[i] = 1;
                a[k] = i;
                if (k == nums.length - 1){
                    addList(nums,a);
                }else {
                    backtracking(nums,a,b,k+1);
                }
                b[i] = 0;
                a[k] = 0;
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        backtracking(nums,new int[len],new int[len],0);
        return arrayLists;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3,4}).toString());
    }
}
