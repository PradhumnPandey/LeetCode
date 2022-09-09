import java.util.*;
class Solution {
   static int ans = -1000000;
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5},-2));
    }

    public static int threeSumClosest(int[] nums, int target) {
      List<Integer> ls = new ArrayList<>();
      for(int i:nums) ls.add(i);
      return sub(ls,0,target,nums.length);
    }
    
    public static int sub(List<Integer> nums, int i, int target,int n)
    {

    if(nums.size() == 3)
        {
            int sum = 0;
            for(int j : nums) sum+=j;
            if(target - sum < target - ans) ans = sum;
            return sum;
        }
      if(i >= nums.size()) return ans;
      int temp = nums.get(i);
      nums.remove(i);
      sub(nums, i, target,n);
      nums.add(i,temp);
      sub(nums, i+1, target,n);
      return ans;
    }
}