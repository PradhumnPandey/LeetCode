import java.util.*;
public class longest_pal {

    List<String> ls = new ArrayList<String>();
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
      int dp[][] = new int[s.length()+1][s.length()+1];
      int max = 0,idxi =0,idxj = 0;
      for(int i = 0; i<s.length(); i++)
      {
        for(int j = s.length() - 1; j>=0 ;j--)
        {
            if(s.charAt(i) == s.charAt(j)) dp[i][j] = 1 + dp[i-1][s.length() - j - 1];
            else dp[i][j] = 0;
            if(dp[i][j] > max)
            {
                max = dp[i][j];
                idxi = i;
                idxj = j;
            }
        }
      }

      return s.substring(idxj - max, idxj + 1);
    }
}