import java.util.*;
public class maxProd_subarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{0,2}));
    }
    public static int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for(int[] i : dp) Arrays.fill(i,1);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length;i++)
        {
            for(int j = i+1; j < nums.length+1;j++)
            {
               dp[i][j] = dp[i][j-1] * nums[j-1];
               max = Math.max(max,dp[i][j]);
            }
        }
    
        return max;
    }
}
