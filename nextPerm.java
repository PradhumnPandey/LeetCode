import java.util.*;
public class nextPerm {
    
    public static void main(String[] args) {
        nextPermutation(new int[]{3,2,1});
    }
    public static void nextPermutation(int[] nums) {
        int n = -1;
      for(int i = nums.length - 1; i>=0; i--)
      {
         
         if(perm(nums[i] , n, nums.length - 1 -i))
         {
           n = n*10 + nums[i];
           String str = "" + n;
           for(int j = nums.length - 1; j>= nums.length - str.length(); j--)
           {
                nums[j] = str.charAt(j - (nums.length - str.length())) - '0';
           }
           break;
         }
         if(n < 0)
         n =+ nums[i];
         else
         n = nums[i]*(int)Math.pow(10,  nums.length - 1 -i) + n;
      }
      Arrays.sort(nums);
    }

    public static boolean perm(int n1, int n2, int i) {
       if(n2 < 0) return false;
       return n2*10 + n1 > n1*Math.pow(10, i) + n2;
    }
}
