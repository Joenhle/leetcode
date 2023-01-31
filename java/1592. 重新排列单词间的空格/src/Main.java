public class Main {

    public static String reorderSpaces(String text) {
        int sum = 0;
        String kongge = new String();
        String res = new String();

        for (int i = 0; i < text.length(); ++i){
            if (text.charAt(i)==' ')
                sum++;
        }


        while (text.indexOf("  ")!=-1){
            text = text.replaceAll("  "," ");
        }
        while (text.charAt(0) == ' '){
            text = text.substring(1);
        }
        String []arr = text.split(" ");

        if (arr.length == 1){
            res = arr[0];
            for (int i = 0; i < sum; ++i){
                res += " ";
            }
            return res;
        }

        for (int i = 0; i < sum/(arr.length-1); ++i){
            kongge += " ";
        }

        for (int i = 0; i < arr.length; ++i){
            res += i==0 ? arr[i] : kongge+arr[i];
        }

        for (int i = 0; i < sum%(arr.length-1); ++i){
            res += " ";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reorderSpaces("a"));
    }
}
