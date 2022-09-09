import java.util.*;
public class house_robber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }

    public static int rob(int[] nums) {
       
        int dp[] = new int[nums.length + 1];
        dp[nums.length] = 0;
        dp[nums.length - 1] = nums[nums.length - 1];
        
        for(int i = nums.length - 2; i>=0 ;i--)
        {
            
        dp[i] =  Math.max(
            nums[i] + dp[i+2],
            dp[i+1]
        );
        }
    return dp[0];        
    }
}
