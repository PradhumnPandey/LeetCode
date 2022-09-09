import java.util.*;
class Solution1 {
   static int ans = -1000000;
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,1,1,1},4));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int ans = 1000000;
        if(nums.length < 4)
            return nums[0]+nums[1]+nums[2];
     
        for(int i = 0 ; i<nums.length-2 ;i++)
        {
            for(int j = i+1, k = nums.length-1; j<k;k--)
            {
                if(Math.abs(target - (nums[i] + nums[j] + nums[k])) <  Math.abs(target - ans))
                {
                    ans = nums[i] + nums[j] + nums[k];
                }
            }
        }
        
        return ans;
    }
}