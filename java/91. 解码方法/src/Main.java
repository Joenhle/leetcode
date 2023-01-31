

public class Main {


    public static int numDecodings(String s) {
      if (s.length()==0 || s.charAt(0) == '0') return 0;
      int []dp = new int[s.length()];
      dp[0] = 1;
      for (int i = 1; i < s.length(); ++i){
          char new_char = s.charAt(i);
          char pre = s.charAt(i-1);

          if (new_char == '0' && pre == '0') return 0;
          if (pre == '0'){
              dp[i] = dp[i-1];
              continue;
          }
          if (new_char == '0'){
              if (pre == '1' || pre == '2'){
                  if (i-2 >= 0)
                      dp[i] = dp[i-2];
                  else
                      dp[i] = 1;
              }else {
                  return 0;
              }
          }else {
              dp[i] = dp[i-1];
              int value = Integer.valueOf(s.substring(i-1,i+1));
              if (value >= 1 && value <= 26){
                  if (i - 2 >= 0)
                      dp[i] += dp[i-2];
                  else
                      dp[i] += 1;
              }
          }
      }
      return dp[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("101"));
    }
}
