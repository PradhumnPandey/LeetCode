import java.util.*;

public class heightHistogram {
    
    public static void main(String[] args) {
        System.out.println(hist(new int[]{2,1,5,6,2,3}));
    }

    public static int hist(int[] nums)
    {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int item ,max = 0,width;
        for(int i = 1; i<= nums.length;i++)
        {
            while(!s.isEmpty() &&( i== nums.length || nums[s.peek()] > nums[i]))
            {
                item = nums[s.pop()];
                if(s.isEmpty()) width = i;
                else width = i - s.peek() - 1;
                max = Math.max(max, width*item);
            }
            s.push(i);
        }

        return max;
    }
}


