public class Main {

    public static int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while (left+1 < arr.length && arr[left] <= arr[left+1]){
            left++;
        }

        if (left + 1 == arr.length) return 0;

        int right = arr.length-1;
        while (right - 1 >= 0 && arr[right] >= arr[right-1]){
            right--;
        }

        int result = arr.length - Math.max(left+1,arr.length-right);
        int i = 0,j = right;
        while (i <= left && j < arr.length){
            if (arr[i] <= arr[j]){
                result = Math.min(result,j - i - 1);
                i++;
            }else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
       System.out.println(findLengthOfShortestSubarray(new int[]{1}));
    }
}
