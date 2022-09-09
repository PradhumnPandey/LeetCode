import java.util.*;
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
    public static int jump(int[] nums) {
        
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        int min = 100000;
        dp[nums.length - 1] = 0;
        for(int i = nums.length - 2; i>=0 ; i--)
        {
            for(int j = i;j<= nums[i] +i && j < nums.length; j++)
            {
                if(nums[j] == 0) continue;
                if(j == nums.length - 1) 
                {
                    dp[j] = 0;
                    continue;
                }
                if((nums[j] + j) >= nums.length - 1)
                {
                    dp[j] = 1;
                    min = dp[j];
                    continue;
                }
                min = Math.min(min,1+dp[j+1]);
            }
            dp[i] = min;
        }
        return dp[0];
    }

    public static int rec(int[] nums, int i)
    {
        if(i == nums.length - 1) return 0;
        int min = 100000;
        for(int j = i+1;j<= nums[i] +i && j < nums.length; j++)
        {
            if(j == nums.length - 1) min = 1;
            if(nums[j] == 0) continue;
            min = Math.min(min,1 + rec(nums,j));
        }
        return min;
    }
}

