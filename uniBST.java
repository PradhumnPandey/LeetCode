import java.util.*;
class uniBST {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
    public static int numTrees(int n) {
    
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
      return rec(n,dp);
}
    public static int rec(int n ,int[] dp)
    {
        if(dp[n] != -1) return dp[n];
        if( n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int sum = 0;
        for(int i = 1;i<=n; i++)
        {
            sum += dp[i - 1] * rec(n - i,dp);
        }
        dp[n] = sum;
        return sum;
    }
}
