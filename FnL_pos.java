public class FnL_pos {
    public static void main(String[] args) {
        searchRange(new int[]{2,2}, 3);
    }
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length < 2) 
        {
            if(nums.length == 1 && nums[0] == target) return new int[]{0,0};
            return new int[]{-1,-1};
        }
        int l = 0, r= nums.length- 1,mid;
        int[] res = new int[]{-1,-1};
        while(l<=r)
        {
            mid = (l+r)/2;
            if(nums[mid] == target)
            {
                if(mid > 0 && nums[mid - 1] == target)
                {
                    res[0] = mid - 1;
                    res[1] = mid;
                }
                else if(mid < nums.length - 1 && nums[mid + 1] == target)
                {
                    res[1] = mid + 1;
                    res[0] = mid;
                }
                else
                {
                    res[0] = mid;
                    res[1] = mid;
                }
                break;
            }
            else if(nums[mid] > target)
            {
                r = mid - 1;
            }
            else
                l = mid+1;
        }
        
        return res;
    }
}
